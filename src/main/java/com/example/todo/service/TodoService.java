package com.example.todo.service;

import com.example.todo.Repository.ITodoRepository;
import com.example.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    //private static List<Todo> todos = new ArrayList<>();
    @Autowired
    ITodoRepository todoRepository;

    /* private static int todoCount = 0; */

    /* static {
        new Todo - means call cons. of Todo.java class
        todos.add(new Todo(++todoCount,"Learn Spring Boot",false));
        todos.add(new Todo(++todoCount,"Visit Grocery Store",false));
        todos.add(new Todo(++todoCount,"Learn AWS",false));
        todos.add(new Todo(++todoCount,"Swimming",false));
        todos.add(new Todo(++todoCount,"Yoga",false));
    } */

    public List<Todo> findAll() {
        //return todos;
        return todoRepository.findAll();
    }


    public String addTodo(Todo todo){
        //todos.add(todo);
        todoRepository.save(todo);
        System.out.println("Todo Added");
        return "Todo Added!!!";
    }

    public Todo findById(Integer todoId){
        return todoRepository.findById(todoId).get();
    }


    public void deleteTodo(Integer todoId){
        todoRepository.deleteById(todoId); //after Repository Layer
    }

    public void updateTodo(Integer todoId, Todo newTodo){

        //Step 1 : find todo to be Update
        //Step 2 : update todo

        if(todoRepository.findById((todoId)).isPresent()){
            Todo todo = todoRepository.findById((todoId)).get();
            newTodo.setTitle(todo.getTitle());
            todoRepository.save(newTodo);
        }
    }
}
