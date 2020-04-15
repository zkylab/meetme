package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mycompany.meetme.repository")
public class MeetmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetmeApplication.class, args);
    }

}
