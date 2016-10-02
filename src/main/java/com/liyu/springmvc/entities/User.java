package com.liyu.springmvc.entities;

/**
 * Created by twcn on 10/2/16.
 */
public class User {

    private String username;
    private String password;
    private String email;
    private int age;
    private Address address;

    @Override
    public String toString() {
        return "User [ username=" + username + " , password=" + password +
                " , email=" + email + " , age=" + age + " ,address=" + address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}