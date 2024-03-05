/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;
import com.example.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoJpaService implements TodoRepository {

    @Autowired
    private TodoJpaRepository tjr;

    @Override
    public ArrayList<Todo> getTodos() {
        List<Todo> l = tjr.findAll();
        ArrayList<Todo> arr = new ArrayList<>(l);
        return arr;
    }

    @Override
    public Todo addTodo(Todo todo) {
        tjr.save(todo);
        return todo;
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            Todo t = tjr.findById(id).get();
            return t;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        try {
            Todo t = tjr.findById(id).get();
            if (todo.getTodo() != null) {
                t.setTodo(todo.getTodo());
            }
            if (todo.getPriority() != null) {
                t.setPriority(todo.getPriority());
            }
            if (todo.getStatus() != null) {
                t.setStatus(todo.getStatus());
            }

            tjr.save(t);
            return t;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            tjr.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
