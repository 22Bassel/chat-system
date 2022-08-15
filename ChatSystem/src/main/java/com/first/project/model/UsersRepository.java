package com.first.project.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UsersRepository  extends JpaRepository<UsersTable,Integer> {
    @Transactional

    @Query(value = "SELECT `id` FROM `users` WHERE `Name` = ?",nativeQuery = true)
    public Integer GetByName(String Name);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `users` WHERE `Name` = ?",nativeQuery = true)
    public void DeleteByName(String Name);



}
