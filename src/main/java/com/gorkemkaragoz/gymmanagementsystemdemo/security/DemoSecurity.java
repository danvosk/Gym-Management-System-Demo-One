package com.gorkemkaragoz.gymmanagementsystemdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurity {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();

        userDetailsManager.setDataSource(dataSource);

        userDetailsManager.setUsersByUsernameQuery(
                "select username, password, enabled from auth_users where username=?");

        userDetailsManager.setAuthoritiesByUsernameQuery("" +
                "select username, authority from auth_roles where username=?");

        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(config -> config

                // 🔹 FoodDrinkType için izinler
                .requestMatchers(HttpMethod.GET,"/api/v1/food-drink-type").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/v1/food-drink-type/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/v1/food-drink-type").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.PUT, "/api/v1/food-drink-type").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/food-drink-type/**").hasRole("ADMIN")

                // 🔹 MenuItems için izinler
                .requestMatchers(HttpMethod.GET,"/api/v1/menu-item").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/v1/menu-item/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/v1/menu-item").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.PUT, "/api/v1/menu-item").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/menu-item/**").hasRole("ADMIN")

                // 🔹 ItemAllergens için izinler
                .requestMatchers(HttpMethod.GET, "/api/v1/item-allergens").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/v1/item-allergens/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/v1/item-allergens").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.PUT, "/api/v1/item-allergens").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/item-allergens/**").hasRole("ADMIN")

                // 🔹 ItemIngredients için izinler
                .requestMatchers(HttpMethod.GET, "/api/v1/item-ingredients").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/v1/item-ingredients/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/v1/item-ingredients").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.PUT, "/api/v1/item-ingredients").hasRole("MODERATOR")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/item-ingredients/**").hasRole("ADMIN")

                // Diğer her şey için authentication zorunlu
                .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
    
}
