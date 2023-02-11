package com.example.oophometask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name  = "adam")
public class Adam {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @Column( nullable = false, length =  50)
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String password;


    public Adam(String name, String surname, String email, String password) {
        setEmail(email);
        setName(name);
        setSurname(surname);
        setPassword(password);
    }
}
