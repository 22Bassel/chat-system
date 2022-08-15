package com.first.project.model;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class UsersTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String Name;

    public UsersTable( String name) {

        Name = name;
    }

    public UsersTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
