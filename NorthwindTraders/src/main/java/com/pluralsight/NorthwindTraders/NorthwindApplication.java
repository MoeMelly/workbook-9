package com.pluralsight.NorthwindTraders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {
    static Scanner scanner = new Scanner(System.in);
    ProductDAO productDAO;

    @Autowired
    public NorthwindApplication(ProductDAO productDAO) {
        this.productDAO = productDAO;


    }

    @Override
    public void run(String... args) throws Exception {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Choose An Option Below: ");
            System.out.println("1. List All Products");
            System.out.println("2. Add a Product");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("All Products:");
                    System.out.println();
                    for (Product product : productDAO.getAll()) {
                        System.out.println(" - " + product);
                    }
                    System.out.println();



                }
                case 2 -> {
                    System.out.println("Enter Custom ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Your Product Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Product Category (Electronics, Food, Music Items, etc...): ");
                    String category = scanner.nextLine();

                    System.out.println("Price: ");
                    BigDecimal price = new BigDecimal(scanner.nextLine());
                    Product product = new Product(id, name, category, price);
                    System.out.println("Added: " + product);
                    productDAO.add(product);
                    break;
                }
                case 3 -> {
                    keepRunning = false;
                    System.out.println("Goodbye!");
                    break;


                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    }



