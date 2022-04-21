package com.lab3.task3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Tests Invoice class
 */
public class InvoiceTester {

    /**
     * Main tester function
     * @param args unused
     */
    public static void main(String[] args) {
        ArrayList<Invoice> invList = new ArrayList<>();
        invList.add(new Invoice(83, "Electric sander", 7, 57.98));
        invList.add(new Invoice(24, "Power saw", 18, 99.99));
        invList.add(new Invoice(7, "Sledge hammer", 11, 21.50));
        invList.add(new Invoice(77, "Hammer", 76, 11.99));
        invList.add(new Invoice(39, "Lawn mower", 3, 79.50));
        invList.add(new Invoice(68, "Screwdriver", 106, 6.99));
        invList.add(new Invoice(56, "Jig saw", 21, 11.00));
        invList.add(new Invoice(3, "Wrench", 34, 7.50));

        System.out.println("Original List : ");
        invList.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Ordered by \"PartDescription\" : ");
        invList.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Ordered by \"Price\" : ");
        invList.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Mapping and Sorting to Quantity : ");
        invList.stream()
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .map((e)->e.getPartDescription() + "\t| qty: " + e.getQuantity())
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Mapping and Sorting to Invoice Total : ");
        invList.stream()
                .sorted(Comparator.comparing(e->e.getQuantity()*e.getPrice()))
                .map((e)->e.getPartDescription() + "\t| invoice: " + (e.getQuantity() * e.getPrice()))
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("Mapping and Sorting to Invoice Total With Limit : ");
        invList.stream()
                .filter(e->e.getQuantity()*e.getPrice() <= 500 && e.getQuantity()*e.getPrice() >= 200)
                .sorted(Comparator.comparing(e->e.getQuantity()*e.getPrice()))
                .map((e)->e.getPartDescription() + "\t| invoice: " + (e.getQuantity() * e.getPrice()))
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------");
    }
}
