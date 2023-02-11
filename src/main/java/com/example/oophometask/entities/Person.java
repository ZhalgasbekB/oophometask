package com.example.oophometask.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name =  "person")
public class Person {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private int id;

    @Column (nullable = false , length = 50)
    private  String name;

    @Column (nullable = false , length = 50)
    private String surname;

    @Column(nullable = false)
    private  int age;

    @Column(nullable = false)
    private  double income;
    @Column (nullable = false , unique = true)
    private  String email;

}
