package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ShapeDao shapeDao = new ShapeDao();

    public static void main(String[] args) {

        boolean exit = false;

        System.out.println("Welcome to CRUD Operations Interface");

        while (!exit) {

            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> create();
                case 2 -> readAll();
                case 3 -> read();
                case 4 -> update();
                case 5 -> delete();
                case 6 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        HibernateUtil.shutdown();
    }

    private static void printMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Create");
        System.out.println("2. Read All");
        System.out.println("3. Read By ID");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
    }

    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void create() {

        System.out.print("If You want to create Rectangle enter 1, if You want to create Triangle enter 2: ");
        int choice = getChoice();

        if (choice == 1) {
            Rectangle rectangle = ShapeFactory.rectangleCreator(scanner);
            shapeDao.save(rectangle);
        } else if (choice == 2) {
            Triangle triangle = ShapeFactory.triangleCreator(scanner);
            shapeDao.save(triangle);
        } else {
            System.out.println("Invalid input");
        }

    }

    private static void readAll() {

        List<Shape> shapes = shapeDao.getAllShapes();

        for (var item : shapes) {
            System.out.println(item );
        }

    }

    private static void read() {

        System.out.print("Enter ID of shape that You want to display: ");
        long id = getChoice();
        Shape shape = shapeDao.getById(id);
        System.out.println(shape);

    }

    private static void update() {

    }

    private static void delete() {

        System.out.print("Enter ID of shape that You want to delete: ");
        long id = getChoice();
        shapeDao.deleteById(id);

    }

}
