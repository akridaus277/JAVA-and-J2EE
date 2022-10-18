package com.example;
public class Employee{
    private Integer id;
    private String fisrtName;
    private String lastName;
    private String location;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFisrtName() {
        return fisrtName;
    }
    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString(){
        return "Employee [id=" + id + ", firstName=" + fisrtName + ", lastName=" + lastName + ", location=" + location + "]";
    }
}