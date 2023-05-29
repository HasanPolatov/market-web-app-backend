package com.example.myfirstfullstackwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "my_user")
@Data
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    private String password;


    public MyUser id(Long id) {
        this.id = id;
        return this;
    }

    public MyUser username(String username) {
        this.username = username;
        return this;
    }

    public MyUser password(String password) {
        this.password = password;
        return this;
    }

}

