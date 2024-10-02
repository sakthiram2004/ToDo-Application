package com.todoapp.ToDo.Application.services;

import com.todoapp.ToDo.Application.entity.Todo;
import com.todoapp.ToDo.Application.entity.User;

import java.util.List;

public interface ITodoService {


    List<Todo> getTodoListByUserId(Long userID);

    public Todo createTodo(Long userID, Todo todo);
}
