/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.robowinzo;
// MenuManager.java
import java.util.Scanner;

public class MenuManager extends RoboticsStore {
    private RoboticsStore store;

    public MenuManager(RoboticsStore store) {
        this.store = store;
    }

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Display Products and Rate");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Registration:");
                    System.out.print("Enter user ID: ");
                    String id = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    store.registerUser(id, email, password);
                }

                case 2 -> {
                    System.out.println("Login:");
                    System.out.print("Enter email: ");
                    String loginEmail = scanner.next();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.next();
                    store.loginUser(loginEmail, loginPassword);
                }

                case 3 -> store.displayProductsAndRate();

                case 4 -> System.out.println("Exiting program. Goodbye!");

                default -> System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }
}

