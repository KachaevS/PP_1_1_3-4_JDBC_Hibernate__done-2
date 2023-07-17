package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ozzy", "Osbourne", (byte) 35);
        userService.saveUser("Tony", "Iommi", (byte) 25);
        userService.saveUser("Geezer", "Butler", (byte) 31);
        userService.saveUser("Bill", "Ward", (byte) 38);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();


    }
}




