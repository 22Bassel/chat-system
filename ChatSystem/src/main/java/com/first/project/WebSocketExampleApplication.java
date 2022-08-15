package com.first.project;

import com.first.project.model.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class WebSocketExampleApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebSocketExampleApplication.class, args);
    }


}

