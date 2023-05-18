package com.example.todo.service;

import com.example.todo.Repository.ITodoRepository;
import com.example.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService implements ITodoService{
    private static List<Todo> todos = new ArrayList<>();
    @Autowired
    ITodoRepository todoRepository;

    /* private static int todoCount = 0; */

    /* static {
        //new Todo - means call cons. of Todo.java class
        todos.add(new Todo(++todoCount,"Learn Spring Boot",false));
        todos.add(new Todo(++todoCount,"Visit Grocery Store",false));
        todos.add(new Todo(++todoCount,"Learn AWS",false));
        todos.add(new Todo(++todoCount,"Swimming",false));
        todos.add(new Todo(++todoCount,"Yoga",false));
    } */

    @Override
    public List<Todo> findAll() {
        //return todos;
        return todoRepository.findAll();
    }

    @Override
    public void addTodo(Todo todo){
        //todos.add(todo);
        todoRepository.save(todo);
        System.out.println("Todo Added");
    }

    @Override
    public Todo findById(int id){
        /* Predicate <? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo; */
        return todoRepository.findById(id).get();
    }

    @Override
    public void deleteTodo(int id){
        /* Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate); */
        todoRepository.deleteById(id); //after Repository Layer
    }

    @Override
    public void updateTodo(int todoId, Todo newTodo){

        //Step 1 : find todo to be Update
        //Step 2 : update todo

        if(todoRepository.findById((todoId)).isPresent()){
            Todo todo = todoRepository.findById((todoId)).get();
            newTodo.setId(todo.getId());
            todoRepository.save(newTodo);
        }
    }
}
