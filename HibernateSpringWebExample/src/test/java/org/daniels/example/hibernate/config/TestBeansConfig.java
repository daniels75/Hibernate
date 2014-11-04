package org.daniels.example.hibernate.config;

import org.daniels.example.hibernate.service.UserDetailsService;
import org.daniels.example.hibernate.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "org.daniels.example.hibernate.repository" })
public class TestBeansConfig {
    
    @Bean 
    UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }
    
}
