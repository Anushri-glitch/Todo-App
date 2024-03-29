package com.example.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    //@Column(name="Todo_title")
    private String title;
    private boolean status;
}
