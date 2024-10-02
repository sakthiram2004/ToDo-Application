package com.todoapp.ToDo.Application.services;

import com.todoapp.ToDo.Application.entity.User;

public interface IUserService {
    User createUser(User user);
    User getUser(Long userId);
    User updateUser(Long userId,User user);

    void deleteById(Long userID);
}
