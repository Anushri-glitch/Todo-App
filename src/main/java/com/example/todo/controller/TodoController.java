package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


     /*1. Used to Inject Dependency
       2. ITodoService is an Interface for  Service class
       3. we make todoService class variable in Controller class for accept list */
     @Autowired
     TodoService todoService;

    /* 1. we don't use default constructor when we use Autowired annotation
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

    //We Done Read Operation In this Part
    //http://localhost:8080/api/v1/todo-app/find-all - we run this api on browser to get api output
    @GetMapping("find-all")
    public List<Todo> findAllTodos(){
        return todoService.findAll(); //Controller is talking to service layer

    }
    @PostMapping("/add-todo")
    public String addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    /* In this method we print Todos By Id...*/
    @GetMapping("findById/todoId/{todoId}")
    public Todo findTodoById(@PathVariable Integer todoId){
       return todoService.findById(todoId);
    }

    //@RequestMapping(value="url",method=HttpRequest.PUT)
    @PutMapping("update-todo/todoId/{todoId}")
    public ResponseEntity<String> updateTodo(@PathVariable Integer todoId, @RequestBody Todo todoRequest){
        //Todo todo = setTodo(todoRequest);
        todoService.updateTodo(todoId, todoRequest);
        return new ResponseEntity("todo updated", HttpStatus.OK);

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
    @DeleteMapping("delete-todo/todoId/{todoId}")
    public void deleteTodo(@PathVariable Integer todoId){
        todoService.deleteTodo(todoId);
    }

//    private Todo setTodo(String todoData){
//        JSONObject jsonObject = new JSONObject(todoData);
//        Todo todo = new Todo();
//
//        todo.setId(jsonObject.getInt("id"));
//        todo.setTitle(jsonObject.getString("title"));
//        todo.setStatus(jsonObject.getBoolean("status"));
//
//        return todo;
//    }


}
