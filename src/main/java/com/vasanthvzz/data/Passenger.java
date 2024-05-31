package com.vasanthvzz.data;

public class Passenger {
    private int id;
    private String name;
    private String gender;
    private int age;

    public Passenger(int age, String gender, int id, String name) {
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.name = name;
    }

    public Passenger() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
