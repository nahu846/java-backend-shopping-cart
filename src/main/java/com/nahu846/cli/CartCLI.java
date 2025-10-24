package com.nahu846.cli;

import com.nahu846.model.Cart;
import com.nahu846.model.CartItem;
import com.nahu846.service.CrudServiceImpl;

import java.util.List;

public class CartCLI {
    private final CrudServiceImpl<Cart> service = new CrudServiceImpl<>();

    public void createTestCarts() {
        service.create(new Cart(1L, new CartItem()));
        service.create(new Cart(2L, new CartItem()));
        service.create(new Cart(3L, new CartItem()));
        service.create(new Cart(4L, new CartItem()));
    }

    private Long count = 5L;

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
        service.create(new Cart(count++, new CartItem()));
    }

    private void findById() {
        System.out.println(service.read(CLIUtils.promptLong("Input id")).toString());
    }

    private void list() {
        List<Cart> carts = service.readAll();
        for (Cart cart : carts) {
            System.out.println(cart.toString());
        }
    }

    private void update() {
        Long id = CLIUtils.promptLong("Input id");
        service.update(id, new Cart(id, new CartItem()));
    }

    private void delete() {
        service.delete(CLIUtils.promptLong("Input id"));
    }
}
