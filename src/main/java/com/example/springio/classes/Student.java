package com.example.springio.classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document("student")
public class Student {

    @Id
    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
