package com.nahu846.cli;

import com.nahu846.model.User;
import com.nahu846.service.CrudServiceImpl;

import java.util.List;

public class UserCLI {
    private final CrudServiceImpl<User> service = new CrudServiceImpl<>();

    public void createTestUsers() {
        service.create(new User(1L, "Ailen"));
        service.create(new User(2L, "Ramon"));
        service.create(new User(3L, "Carlos"));
        service.create(new User(4L, "Maria"));
    }

    private Long count = 5L;

    public List<User> retrieveUsers() {
        return service.readAll();
    }

    public void start() {
        while (true) {
            System.out.println("\n=== User CRUD ===");
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
        service.create(new User(count++, CLIUtils.prompt("Write your name")));
    }

    private void findById() {
        System.out.println(service.read(CLIUtils.promptLong("Input id")).toString());
    }

    private void list() {
        List<User> users = service.readAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    private void update() {
        Long id = CLIUtils.promptLong("Input id");
        service.update(id, new User(id, CLIUtils.prompt("Write your name")));
    }

    private void delete() {
        service.delete(CLIUtils.promptLong("Input id"));
    }
}
