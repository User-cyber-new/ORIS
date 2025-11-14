package org.example.entities;

public class Course {
    private Integer id;
    private String name;
    private Integer price;

    public Course(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price;
    }
}
