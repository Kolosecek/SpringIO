package com.example.springio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class SpringIoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIoApplication.class, args);
    }

    //FIXME: mozno nebude zle presunut sem ten formular kedze toto je akoze "index"
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

}
