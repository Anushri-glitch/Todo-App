# Todo-App
Todo Application Pushed By IntellijIDE
This Application Uses H2 Database...
##### :purple_square: Its an API Based Web Application
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
    4. SQL with H2 Database
    
## :two: Dependency Used
    1. Spring Web
    2. Spring Boot Dev Tools
    3. Lombok
    4. Spring Data JPA
    5. H2 database
    6. Swagger UI
    7. Hibernate
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: Dataflow (Functions Used In)
### :purple_square: 1. Model - Model is used to Iniitialize the required attributes and create the accessable constructors and methods
#### :o: Todo.java
```java
@Entity
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String title;
    private boolean status;
}
```

##### To See Model
:white_check_mark: [Todo-Model](https://github.com/Anushri-glitch/Todo-App/tree/master/src/main/java/com/example/todo/model)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 2. Service - This Layer is used to write the logic of our CRUD operaions.
#### :o: TodoService.java
```java
@Service
public class TodoService {
    @Autowired
    ITodoRepository todoRepository;
    
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}
```

#### To See Service
:white_check_mark: [Todo-Service](https://github.com/Anushri-glitch/Todo-App/tree/master/src/main/java/com/example/todo/service)
----------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 3. Controller - This Controller is used to like UI between Model and Service and also for CRUD Mappings.
#### :o: TodoController.java
```java
@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {

     @Autowired
     TodoService todoService;

    @PostMapping("/add-todo")
    public String addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
}
```

#### To See Controller
:white_check_mark: [Todo-Controller](https://github.com/Anushri-glitch/Todo-App/tree/master/src/main/java/com/example/todo/controller)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :purple_square: 3. Repository : data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanisms.
#### :o: ITodoRepository.java
```java
@Repository
public interface ITodoRepository extends JpaRepository<Todo,Integer> {
}
```

#### To See Repository
:white_check_mark: [Todo-DAO](https://github.com/Anushri-glitch/Todo-App/tree/master/src/main/java/com/example/todo/Repository)
-------------------------------------------------------------------------------------------------------------------------------------------------------

## :four: DataStructures Used in Project
    1. ResponseEntity
    2. List
    3. JsonObject
    4. JsonArray
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :five: DataBase Response In project

:arrow_right: Todo table
![Screenshot (817)](https://github.com/Anushri-glitch/Todo-App/assets/47708011/6d5feb1f-291c-4af7-b7d3-94d3dc4279b0)

----------------------------------------------------------------------------------------------------------------------------------------------------------
## :six: Project Summary
### :o: Generated API's

:white_check_mark: ADD TODO : localhost:8080/api/v1/todo-app/add-todo

:white_check_mark: GET ALL TODO : localhost:8080/api/v1/todo-app/findall

:white_check_mark: GET TODO BY ID : localhost:8080/api/v1/todo-app/findById/todoId/{todoId}

:white_check_mark: UPDATE TODO : localhost:8080/api/v1/todo-app/update-todo/todoId/{todoId}

:white_check_mark: DELETE TODO : localhost:8080/api/v1/todo-app/delete-todo/todoId/{todoId}

--------------------------------------------------------------------------------------------------------------------------------------------------

## :seven: Project Result
### :o: Todo Response

![Screenshot (813)](https://github.com/Anushri-glitch/Todo-App/assets/47708011/d861f3ab-5252-4fe9-999a-adcd32edbab3)
![Screenshot (814)](https://github.com/Anushri-glitch/Todo-App/assets/47708011/c2a2dac8-1dba-422d-8ab4-f4cd8ca453b8)
![Screenshot (818)](https://github.com/Anushri-glitch/Todo-App/assets/47708011/6ec25a4b-f231-41f6-911d-acfe86976779)
![Screenshot (815)](https://github.com/Anushri-glitch/Todo-App/assets/47708011/41760f8d-7af1-41ab-b098-f40ab35515b8)
![Screenshot (816)](https://github.com/Anushri-glitch/Todo-App/assets/47708011/76f04433-e533-4c7e-9b5a-5fd11269d50a)

-----------------------------------------------------------------------------------------------------------------------------------------------------



