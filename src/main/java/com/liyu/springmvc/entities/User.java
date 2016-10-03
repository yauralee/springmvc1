package com.liyu.springmvc.entities;

/**
 * Created by twcn on 10/2/16.
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private int age;
    private Address address;

//    @Override
//    public String toString() {
//        return "User [ username=" + username + " , password=" + password +
//                " , email=" + email + " , age=" + age + " ,address=" + address + "]";
//    }
    @Override
    public String toString() {
        return "User [ id = " + id + " , username=" + username + " , password=" + password +
                " , email=" + email + " , age=" + age + "]";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public User(Integer id, String username, String password, String email, int age){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public User(){

    }

}
