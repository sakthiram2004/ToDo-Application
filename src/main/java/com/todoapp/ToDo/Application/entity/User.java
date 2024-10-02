package com.todoapp.ToDo.Application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userID;
    @Column(nullable = false,unique = true,length = 50)
    private String username;
    @Column(nullable = false,unique = true,length = 50)
    private String email;
    @Column(nullable = false,length = 15)
    private String password;
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false,updatable = true)
    private LocalDateTime updatedAt = LocalDateTime.now();


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    private void setUpdatedAt(){
        this.updatedAt=LocalDateTime.now();
    }

}
