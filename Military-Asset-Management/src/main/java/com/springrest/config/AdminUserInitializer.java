package com.springrest.config;

import com.springrest.model.User;
import com.springrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner initAdminUser(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("1234"));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("✅ Default admin user created (admin / 1234)");
            } else {
                System.out.println("✅ Admin user already exists");
            }
        };
    }
}
