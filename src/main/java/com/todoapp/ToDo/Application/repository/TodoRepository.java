package com.todoapp.ToDo.Application.repository;

import com.todoapp.ToDo.Application.entity.Todo;
import com.todoapp.ToDo.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByUser(User user);
}
