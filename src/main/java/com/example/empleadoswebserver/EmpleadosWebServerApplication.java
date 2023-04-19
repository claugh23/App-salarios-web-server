package com.example.empleadoswebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ServletComponentScan
@EnableMongoRepositories(basePackages = {"com.example.empleadoswebserver.Repositories"})
@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class EmpleadosWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpleadosWebServerApplication.class, args);
    }

}
