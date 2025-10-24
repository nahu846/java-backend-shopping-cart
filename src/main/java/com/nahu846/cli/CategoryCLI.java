package com.nahu846.cli;

import com.nahu846.model.Category;
import com.nahu846.service.CrudServiceImpl;

import java.util.List;

public class CategoryCLI {
    private final CrudServiceImpl<Category> service = new CrudServiceImpl<>();

    public void createTestCategories() {
        service.create(new Category(1L, "Electronics"));
        service.create(new Category(2L, "Kitchen Appliance"));
        service.create(new Category(3L, "Home Appliance"));
        service.create(new Category(4L, "Refrigeration"));
    }

    private Long count = 5L;

    public void start() {
        while (true) {
            System.out.println("\n=== Category CRUD ===");
            System.out.println("1. Create");
            System.out.println("2. Read by Id");
            System.out.println("3. Read All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");

            switch (CLIUtils.promptInt("Choose option: ")) {
                case 1 -> create();
                case 2 -> findById();
                case 3 -> list();
                case 4 -> update();
                case 5 -> delete();
                case 0 -> {return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void create() {
        service.create(new Category(count++, CLIUtils.prompt("Write category name")));
    }

    private void findById() {
        System.out.println(service.read(CLIUtils.promptLong("Input id")).toString());
    }

    private void list() {
        List<Category> categories = service.readAll();
        for (Category category : categories) {
            System.out.println(category.toString());
        }
    }

    private void update() {
        Long id = CLIUtils.promptLong("Input id");
        service.update(id, new Category(id, CLIUtils.prompt("Write category name")));
    }

    private void delete() {
        service.delete(CLIUtils.promptLong("Input id"));
    }
}

