package com.nahu846.cli;

import com.nahu846.model.Product;
import com.nahu846.service.CrudServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class ProductCLI {
    private final CrudServiceImpl<Product> service = new CrudServiceImpl<>();

    public void createTestProducts() {
        service.create(new Product(1L, "Freezer", new BigDecimal(300)));
        service.create(new Product(2L, "SmartTv", new BigDecimal(300)));
        service.create(new Product(3L, "DishWasher", new BigDecimal(300)));
        service.create(new Product(4L, "WashingMachine", new BigDecimal(300)));

    }

    private Long count = 5L;

    public List<Product> retrieveProducts() {
        return service.readAll();
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Product CRUD ===");
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
        service.create(new Product(count++, CLIUtils.prompt("Write product name"), CLIUtils.promptBigDecimal("Write price")));
    }

    private void findById() {
        System.out.println(service.read(CLIUtils.promptLong("Input id")).toString());
    }

    private void list() {
        List<Product> products = service.readAll();
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    private void update() {
        Long id = CLIUtils.promptLong("Input id");
        service.update(id, new Product(id, CLIUtils.prompt("Write product name"), CLIUtils.promptBigDecimal("Write price")));
    }

    private void delete() {
        service.delete(CLIUtils.promptLong("Input id"));
    }
}
