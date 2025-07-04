package com.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults()) // Enable CORS
            .csrf(csrf -> csrf.disable())   // Disable CSRF for simplicity (you can secure this later)
            .authorizeHttpRequests(auth -> auth
            	    .requestMatchers("/api/equipment/**").hasAnyRole("ADMIN", "COMMANDER", "LOGISTICS")
            	    .requestMatchers(HttpMethod.POST, "/api/bases/**").hasAnyRole("ADMIN", "COMMANDER") // ✅ Add this
            	    .requestMatchers("/api/bases/**").hasAnyRole("ADMIN", "COMMANDER", "LOGISTICS") // ✅ ADD THIS
            	    .requestMatchers("/api/purchases/**", "/api/transfers/**").hasAnyRole("ADMIN", "LOGISTICS")
            	    .requestMatchers("/api/assignments/**", "/api/dashboard/**").hasAnyRole("ADMIN", "COMMANDER")
            	    .requestMatchers("/api/admin/**").hasRole("ADMIN")
            	    .requestMatchers("/api/users/**").permitAll()
            	    .anyRequest().authenticated()
            	)

            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // ✅ Add this CORS configuration (Important for Netlify/Render communication)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*") // Replace with specific Netlify/Vercel URL if needed
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
            }
        };
    }
}
