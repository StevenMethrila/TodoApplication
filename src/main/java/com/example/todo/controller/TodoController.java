/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo.controller;

import com.example.todo.service.TodoJpaService;
import com.example.todo.model.Todo;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    // @Autowired
    // private TodoJpaService tjs;

    // @GetMapping("/todos")
    // public ArrayList<Todo> getMethod() {
    // return tjs.getAll();
    // }

    // @PostMapping("/todos")
    // public Todo postMethod(@RequestBody Todo todo) {
    // return tjs.creatTodo(todo);
    // }

    // @GetMapping("/todos/{id}")
    // public Todo getMethodById(@PathVariable("id") int id) {
    // return tjs.getByid(id);
    // }

    // @PutMapping("/todos/{id}")
    // public Todo putMethod(@PathVariable("id") int id, @RequestBody Todo todo) {
    // return tjs.updateByid(id, todo);
    // }

    // @DeleteMapping("/todos/{id}")
    // public void deleteMethod(@PathVariable("id") int id) {
    // tjs.remove(id);
    // }
    @Autowired
    private TodoJpaService todoService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }
}