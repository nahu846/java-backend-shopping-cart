package com.nahu846;

import com.nahu846.cli.*;

public class Main {
    public static void main(String[] args) {

        UserCLI userCLI = new UserCLI();
        userCLI.createTestUsers();
        ProductCLI productCLI = new ProductCLI();
        productCLI.createTestProducts();
        CategoryCLI categoryCLI = new CategoryCLI();
        categoryCLI.createTestCategories();
        OrderCLI orderCLI = new OrderCLI(userCLI, productCLI);
        orderCLI.createTestOrders();


        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Product CRUD");
            System.out.println("2. Category CRUD");
            System.out.println("3. User CRUD");
            System.out.println("4. Role CRUD");
            System.out.println("5. Order CRUD");
            System.out.println("6. Cart CRUD");
            System.out.println("0. Exit");

            int option = CLIUtils.promptInt("Choose option");

            switch (option) {
                case 1 -> productCLI.start();
                case 2 -> categoryCLI.start();
                case 3 -> userCLI.start();
                case 4 -> new RoleCLI().start();
                case 5 -> orderCLI.start();
                case 6 -> new CartCLI().start();
                case 0 -> {
                    System.out.println("Bye 👋");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}