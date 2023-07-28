package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dog_id;
    private String name;
    private int age;
    private int owner_id;

    public Dog() {}
    public Dog(int id, String name, int age, int ownerid) {
        this.dog_id = id;
        this.name = name;
        this.age = age;
        this.owner_id = ownerid;
    }

    public int getId() {
        return dog_id;
    }

    public void setId(int id) {
        this.dog_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOwnerid() {
        return owner_id;
    }

    public void setOwnerid(int ownerid) {
        this.owner_id = ownerid;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + dog_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ownerid=" + owner_id +
                '}';
    }
}
