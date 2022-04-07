package com.patrickmm12.ecommercesystem.config;

import java.util.Arrays;

import com.patrickmm12.ecommercesystem.entities.User;
import com.patrickmm12.ecommercesystem.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // Informar ao Spring Boot que essa classe é especifica de configuração
@Profile("test") // Classe especifica de perfil de "test"
public class TestConfig implements CommandLineRunner {

    @Autowired // Auto injeção de dependência
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
