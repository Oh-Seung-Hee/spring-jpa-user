package com.springjpauser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringJpaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaUserApplication.class, args);
    }

}
