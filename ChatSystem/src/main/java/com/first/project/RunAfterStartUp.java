package com.first.project;

import com.first.project.model.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartUp{
    @Autowired
    private UsersRepository users_repository;

    @EventListener(ApplicationReadyEvent.class)
    public void run(){

        users_repository.deleteAll();
        System.out.println("DB is empty now !! ");
    }
}
