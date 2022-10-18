package com.challenge;
public class User{
    int id;
    private String fisrtName;
    private String lastName;
    public User(){
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(id).append(":").append(fisrtName).append(":").append(lastName);
        return builder.toString();
    }
}