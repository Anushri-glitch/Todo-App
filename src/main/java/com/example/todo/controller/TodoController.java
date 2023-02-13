package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {

    /* @RequestMapping("/message")
    public String msg(){
        return "Good Evening";
    } */

    /* @PostMapping("/create-todo/id/{id}/title/{title}")
    public void createTodo(){}
    public Todo findTodoById(){}
    public Todo findAllTodos(){}
    public Todo deleteTodo(){}
    public Todo updateTodo(){} */

    //By URI Path
    /* @RequestMapping("/api")
    public String helloUser(@RequestParam String username){
        return "hello " + username;
    } */

    //By Query Parameter
    /* @RequestMapping("/api/username/{username}")
    public String helloUser(@PathVariable String username){
        return "hello " + username;
    } */

    //TODO APP - CREATE/FETCH/UPDATE/DELETE

    @Autowired    //Used to Inject Dependency
    //ITodoService is an Interface for  Service class
    /* we make todoService class variable in Controller class for accept list*/
    private ITodoService todoService;

    /* 1. we dont use default constructor when we use Autowired annotation
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }*/

    /* 1. complete coding part in service and controller
       2. just copy this url = http://localhost:8080/api/v1/todo-app/add-todo and use postman with POST method
       3. copy any one Json response into body of postman
       4. hit the send button - if successful then go to browser
       5. use self made Rest Api  - localhost:8080/api/v1/todo-app
       6. Add that Api which we make for addTodo service on the browser
       7. The Api is - http://localhost:8080/api/v1/todo-app/find-all
       8. hit on search button and see which new Json data we add recently it is showing in our self maked Rest Api Json Data's List
       9. So By this function we create our new Json data and add in the List
     */
    @PostMapping("/add-todo")
    public void addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }

    /* In this method we print Todos By Id...*/
    @GetMapping
    public Todo findTodoById(@PathVariable int id){
    return null;
    }

    //We Done Read Operation In this Part
    //http://localhost:8080/api/v1/todo-app/find-all - we run this api on browser to get api output
    @GetMapping("find-all")
    public List<Todo> findAllTodos(){
        return todoService.findAll(); //Controller is talking to service layer

    }


    //@RequestMapping(value="url",method=HttpRequest.PUT)
    @PutMapping("update-todo/id/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(id,todo);
    }

    /* 1. We Done Deletion in this part
       2. complete coding part of service and controller
       3. copy this url in the postman to delete any Json - localhost:8080/api/v1/todo-app/delete-todo/id/{id}
       4. {id} = any id from Json Data List
       5. Dont copy the Json Data from Api Because there is no need
       6. Change the Postman method as Delete
       7. hit the send button and if no any error it means that id Json data is deleted
       8. For checking that Json data will be deleted or not call this Api -
          localhost:8080/api/v1/todo-app/find-all
     */
    @DeleteMapping("delete-todo/id/{id}")
    public void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }




}
