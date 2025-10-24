package com.nahu846.cli;

import com.nahu846.model.Order;
import com.nahu846.model.User;
import com.nahu846.service.CrudServiceImpl;

import java.util.List;
import java.util.Objects;

public class OrderCLI {
    private final CrudServiceImpl<Order> service = new CrudServiceImpl<>();
    UserCLI userCLI;
    ProductCLI productCLI;

    public OrderCLI(UserCLI userCLI, ProductCLI productCLI) {
        this.userCLI = userCLI;
        this.productCLI = productCLI;
    }

    public void createTestOrders() {
        service.create(new Order(1L, userCLI.retrieveUsers().get(1)));
        service.create(new Order(2L, userCLI.retrieveUsers().get(2)));
        service.create(new Order(3L, userCLI.retrieveUsers().get(3)));
        service.create(new Order(4L, userCLI.retrieveUsers().get(0)));
    }

    private Long count = 5L;

    public void start() {
        while (true) {
            System.out.println("\n=== Order CRUD ===");
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
        service.create(new Order(count++, retrieveUserById(CLIUtils.promptLong("Input id"))));
    }

    private void findById() {
        System.out.println(service.read(CLIUtils.promptLong("Input id")).toString());
    }

    private void list() {
        List<Order> orders = service.readAll();
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    private void update() {
        Long id = CLIUtils.promptLong("Input id");
        //service.update(id, new Order(id, CLIUtils.prompt("Write order name"), CLIUtils.promptBigDecimal("Write price")));
    }

    private void delete() {
        service.delete(CLIUtils.promptLong("Input id"));
    }

    private User retrieveUserById(Long id) {
        for (User user : userCLI.retrieveUsers()) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }
}
