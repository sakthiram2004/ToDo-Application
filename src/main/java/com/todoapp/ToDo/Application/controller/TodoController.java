package com.todoapp.ToDo.Application.controller;

import com.todoapp.ToDo.Application.entity.Todo;
import com.todoapp.ToDo.Application.response.ApiResponse;
import com.todoapp.ToDo.Application.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getTodoByuserId(@PathVariable Long userId){
        try {
            List<Todo> todos =  todoService.getTodoListByUserId(userId);
            return ResponseEntity.ok(new ApiResponse("successfully fetched",todos));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Error : " + e.getMessage(), null));

        }
    }

    @PostMapping("/createtodo/{userId}")
    public ResponseEntity<ApiResponse> createTodo(@PathVariable Long userId, @RequestBody Todo todo){
        try {
            Todo todos =  todoService.createTodo(userId,todo);
            return ResponseEntity.ok(new ApiResponse("successfully created",todos));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Error : " + e.getMessage(), null));

        }
    }
}
