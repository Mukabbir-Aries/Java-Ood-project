/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.robowinzo;
class RoboticsProduct extends Product {
    public RoboticsProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("Product: " + getName());
        System.out.println("Price: $" + getPrice());
    }
}
