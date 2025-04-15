USE gym_management_system;

DROP TABLE IF EXISTS `auth_roles`;
DROP TABLE IF EXISTS `auth_users`;


CREATE TABLE `auth_users` (
  username VARCHAR(100) NOT NULL PRIMARY KEY,
  password CHAR(75) NOT NULL,
  enabled TINYINT(1) NOT NULL
) ;

-- NOTE: The passwords are encrypted using BCrypt
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
-- Default passwords here are: 1910Ankaragucu

INSERT INTO `auth_users`
VALUES
('member','{bcrypt}$2a$10$qdhSgJKTfbkentG/ZvCMXeIC6bUITLbq.NtRZ.o/rjbL83IyN8KU6',1),
('trainer','{bcrypt}$2a$10$4yLRPe3LQJuSldOeaBEEB.bw7Lpg3x/ufdqTe.H6uptMWkamrusei',1),
('manager','{bcrypt}$2a$10$nwgyn8fzQog8yvUpDyu4h.R0A0xGATGmJUxqYCF29uyd8jEfjXwzi',1);

CREATE TABLE `auth_roles` (
  username VARCHAR(100) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES auth_users(username),
  PRIMARY KEY (username, authority)
) ;

INSERT INTO `auth_roles`
VALUES
('member','ROLE_USER'),
('trainer','ROLE_USER'),
('trainer','ROLE_MODERATOR'),
('manager','ROLE_USER'),
('manager','ROLE_MODERATOR'),
('manager','ROLE_ADMIN');