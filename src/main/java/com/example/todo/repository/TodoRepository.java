// // Write your code here
// package com.example.todo.repository;

// import com.example.todo.model.Todo;
// import java.util.ArrayList;

// public interface TodoRepository {

//     public ArrayList<Todo> getTodos();

//     public Todo addTodo(Todo todo);

//     public Todo getTodoById(int id);

//     public Todo updateTodo(int id, Todo todo);

//     public void deleteTodo(int id);
// }

package com.example.todo.repository;


import com.example.todo.model.Todo;
import java.util.ArrayList;


public interface TodoRepository {


    ArrayList<Todo> getTodos();


    Todo addTodo(Todo todo);


    Todo getTodoById(int id);


    Todo updateTodo(int id, Todo todo);


    void deleteTodo(int id);
}