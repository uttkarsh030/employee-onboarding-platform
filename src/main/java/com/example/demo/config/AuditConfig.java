package com.example.demo.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class AuditConfig {

    @Bean(name = "auditorAware")
    public AuditorAware<String> auditorAware() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            
            // Debug log - check console
            System.out.println("=== AuditorAware called ===");
            System.out.println("Authentication: " + authentication);
            
            if (authentication == null 
                || !authentication.isAuthenticated() 
                || "anonymousUser".equals(authentication.getName())) {
                System.out.println("No auth found, using SYSTEM");
                return Optional.of("SYSTEM");
            }
            
            System.out.println("Current user: " + authentication.getName());
            return Optional.of(authentication.getName());
        };
    }
}