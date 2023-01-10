package com.example.doan_ecomjpshop;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DoAnEcomJpShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoAnEcomJpShopApplication.class, args);
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public Slugify slugify() {
        return Slugify.builder()
                .lowerCase(true)
                .customReplacement("đ", "d")
                .customReplacement("Đ", "d")
                .build();
    }
}
