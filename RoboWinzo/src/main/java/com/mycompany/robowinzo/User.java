/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.robowinzo;
class User {
    private String id;
    private String email;
    private String password;
    private double dollars;

    public User(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.dollars = 0.0;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getDollars() {
        return dollars;
    }

    public void rewardDollars(double rating) {
        dollars += rating * 2;
    }
public boolean authenticate(String enteredPassword) {
        return getPassword().equals(enteredPassword);
    }
}

