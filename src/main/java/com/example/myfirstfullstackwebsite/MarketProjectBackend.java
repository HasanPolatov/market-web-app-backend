package com.example.myfirstfullstackwebsite;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@RequiredArgsConstructor
public class MarketProjectBackend {

    private final DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(MarketProjectBackend.class, args);
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

}
