package com.todoapp.ToDo.Application.services;

import com.todoapp.ToDo.Application.entity.Todo;
import com.todoapp.ToDo.Application.entity.User;
import com.todoapp.ToDo.Application.exceptions.ResourceNotFoundException;
import com.todoapp.ToDo.Application.repository.TodoRepository;
import com.todoapp.ToDo.Application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Todo> getTodoListByUserId(Long userID) {
        User user = userRepository.findById(userID).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        return todoRepository.findByUser(user);
    }

    @Override
    public Todo createTodo(Long userID, Todo todo) {
        User user = userRepository.findById(userID).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        todo.setUser(user);
        return todoRepository.save(todo);
    }
}



