package com.example.todolistbackend.service;

import com.example.todolistbackend.controller.todoReq;
import com.example.todolistbackend.entity.Todo;
import com.example.todolistbackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getTodos(Boolean status) {
        return todoRepository.getTodosByStatus(status);
    }

    public Todo getTodoById(Integer id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            return todoOptional.get();
        }
        throw new RuntimeException("Not found todo with id = " + id);
    }

    public Todo saveTodo(todoReq savedTodo) {
        Todo customer = new Todo();
        customer.setTitle(savedTodo.title());
        todoRepository.save(customer);
        return customer;
    }

    public Todo updateTodo(int id, todoReq savedTodo) {
        Todo customer = todoRepository.findById(id).get();
        customer.setTitle(savedTodo.title());
        customer.setStatus(savedTodo.status());
        todoRepository.save(customer);
        return customer;
    }

    public Todo deleteTodo(int id) {
        Todo customer = todoRepository.findById(id).get();
        todoRepository.deleteById(id);
        return customer;
    }


}
