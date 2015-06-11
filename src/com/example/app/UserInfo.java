package com.example.app;

/**
 * Created by Nayan on 11 June, 2015
 */
public class UserInfo {
    private String name;
    private int age;

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

    public String getNameInUpperCase(){
        return this.getName().toUpperCase();
    }

    public String getNameInLowerCase(){
        return this.getName().toLowerCase();
    }

    public boolean isOlderThan(int age){
        return this.age > age;
    }
}
