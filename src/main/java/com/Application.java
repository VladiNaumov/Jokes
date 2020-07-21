package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
    public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostConstruct
    // создание таблицы в БД
    private void createJokesTable() {
      jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS jokes (joke text)");


    }
}

