package com.todoapp.ToDo.Application.services;

import com.todoapp.ToDo.Application.entity.User;
import com.todoapp.ToDo.Application.exceptions.ResourceNotFoundException;
import com.todoapp.ToDo.Application.repository.TodoRepository;
import com.todoapp.ToDo.Application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Override
    public User createUser(User user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
    throw new ResourceNotFoundException("user Already Exist");
        }

        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        return user;
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long userID) {
        User user = userRepository.findById(userID).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
        userRepository.deleteById(userID);
    }
}
