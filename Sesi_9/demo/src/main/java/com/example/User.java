package com.example;
public class User{
    int id;
    private String Name;
    private String Gender;
    private String role;
    public User(){
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setGender(String gender) {
        this.Gender = gender;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("User{").append("id=").append(id).append(", Name=").append(Name).append(", gender=").append(Gender).append(", role=").append(role).append("}");
        return builder.toString();
    }
}