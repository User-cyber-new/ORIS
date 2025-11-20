package org.example.entities;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String name;
    private Integer price;

    public Course(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Course(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Course(Integer id, Integer price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price;
    }
}
