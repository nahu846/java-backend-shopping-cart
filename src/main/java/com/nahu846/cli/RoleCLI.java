package com.nahu846.cli;

public class RoleCLI {
    public void start() {
        while (true) {
            System.out.println("\n=== Category CRUD ===");
            System.out.println("1. Create");
            System.out.println("2. Read All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");

            switch (CLIUtils.promptInt("Choose option: ")) {
                case 1 -> create();
                case 2 -> list();
                case 3 -> update();
                case 4 -> delete();
                case 0 -> {return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void create() {
    }

    private void list() {
    }

    private void update() {
    }

    private void delete() {
    }
}
