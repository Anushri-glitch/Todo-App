package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService implements ITodoService{
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    static {
        /* new Todo - means call cons. of Todo.java class */
        todos.add(new Todo(++todoCount,"Learn Spring Boot",false));
        todos.add(new Todo(++todoCount,"Visit Grocery Store",false));
        todos.add(new Todo(++todoCount,"Learn AWS",false));
        todos.add(new Todo(++todoCount,"Swimming",false));
        todos.add(new Todo(++todoCount,"Yoga",false));
    }

    public List<Todo> findAll() {
        return todos;
    }

    public void addTodo(Todo todo){
        todos.add(todo);
    }

    public Todo findById(int id){
        Predicate <? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void deleteTodo(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(int id, Todo newTodo){

        //Step 1 : find todo to be Update
        //Step 2 : update todo

        Todo todo = findById(id);
        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.isStatus());
    }
}
