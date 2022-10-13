package com.example.todolistbackend.controller;

import com.example.todolistbackend.entity.Todo;
import com.example.todolistbackend.exception.ErrorMessage;
import com.example.todolistbackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getTodos(@RequestParam Optional<Boolean> status) {
        if(status.isPresent()) {
            return todoService.getTodos(status.get());
        }
        return todoService.getTodos();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(todoService.getTodoById(id));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(
                    new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage()),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping("/todos")
    public Todo addTodos(@RequestBody todoReq TodoReq){
        return todoService.saveTodo(TodoReq);
    }

    @PutMapping(value="todos/{id}")
    public Todo updateBookById(@PathVariable("id") int id, @RequestBody todoReq TodoReq) {
        return todoService.updateTodo(id,TodoReq);
    }

    @DeleteMapping(value="todos/{id}")
    public Todo deleteBookById(@PathVariable("id") int id) {
        return todoService.deleteTodo(id);
    }

}
