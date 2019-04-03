package com.example.takehomeassignment09_yuqingw;

public class Person {

    private String name;
    private String gender;
    private int age;
    private boolean famous;

    public Person(){
    }

    public Person(String name,String gender,int age,boolean famous){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.famous = famous;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                "\nGender: "+ gender +
                "\nAge: "+ age +
                "\nFamous: "+ famous;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getGender(){
        return  gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public boolean isFamous(){
        return famous;
    }
    public void setFamous(boolean famous){
        this.famous = famous;
    }
}
