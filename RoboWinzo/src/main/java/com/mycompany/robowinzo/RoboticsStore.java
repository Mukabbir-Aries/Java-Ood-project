/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.robowinzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoboticsStore {
    private List<RoboticsProduct> products;
    private List<User> users;
    private User currentUser;
    private MenuManager menumanager;

    public RoboticsStore() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.menumanager = new MenuManager(this);
        products.add(new RoboticsProduct("Robot Kit", 199.99));
        products.add(new RoboticsProduct("Drone", 149.99));
        products.add(new RoboticsProduct("Smart Vacuum", 99.99));

    }

    public void registerUser(String id, String email, String password) {
        User newUser = new User(id, email, password);
        users.add(newUser);
        System.out.println("Registration successful!");
    }

    public void loginUser(String email, String password) {
        User foundUser = findUserByEmail(email);
        if (foundUser != null && foundUser.authenticate(password)) {
            currentUser = foundUser;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
    }

    private User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void displayProductsAndRate() {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }

        System.out.println("Enter the product number to rate (1-" + products.size() + "): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        int productNumber = scanner.nextInt();

        if (productNumber >= 1 && productNumber <= products.size()) {
            System.out.println("Enter your rating (1-5): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                return;
            }

            double rating = scanner.nextDouble();

            if (rating >= 1 && rating <= 5) {
                RoboticsProduct selectedProduct = products.get(productNumber - 1);
                selectedProduct.display();
                currentUser.rewardDollars(rating);
                System.out.println("Thank you for rating! You earned $" + rating * 2 + " dollars.");
            } else {
                System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
            }
        } else {
            System.out.println("Invalid product number. Please enter a number between 1 and " + products.size() + ".");
        }
    }

    void showMainMenu() {
            menumanager.showMainMenu();
    }
}