package com.pgcrp.generictoolkit;

import com.pgcrp.generictoolkit.generics.Box;
import com.pgcrp.generictoolkit.generics.GenericUtils;
import com.pgcrp.generictoolkit.generics.Pair;
import com.pgcrp.generictoolkit.model.Product;
import com.pgcrp.generictoolkit.resource.CustomResource;
import com.pgcrp.generictoolkit.service.ProductReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericToolkitApplication {

    public static void main(String[] args) {

        System.out.println("===== GENERIC TOOLKIT =====");

        System.out.println("\n===== PAIR DEMO =====");

        Pair<Integer, String> pair =
                new Pair<>(101, "Laptop");

        System.out.println(pair);

        System.out.println("\n===== BOX DEMO =====");

        Box<Integer> integerBox = new Box<>(100);
        Box<Double> doubleBox = new Box<>(99.5);

        System.out.println(integerBox);
        System.out.println(doubleBox);

        System.out.println(
                "Double Value: " + integerBox.getDoubleValue()
        );

        System.out.println("\n===== GENERIC MAX DEMO =====");

        System.out.println(
                "Maximum Integer: " + GenericUtils.max(10, 20)
        );

        System.out.println(
                "Maximum String: " +
                        GenericUtils.max("Apple", "Mango")
        );

        System.out.println("\n===== WILDCARD DEMO =====");

        List<Integer> numbers = Arrays.asList(10, 20, 30);

        System.out.println("Unbounded Wildcard:");

        GenericUtils.printList(numbers);

        System.out.println(
                "Sum: " + GenericUtils.sumNumbers(numbers)
        );

        List<Number> numberList = new ArrayList<>();

        GenericUtils.addIntegers(numberList);

        System.out.println(
                "Lower Bounded Wildcard: " + numberList
        );

        System.out.println("\n===== CSV FILE READING =====");

        List<Product> products = ProductReader.readProducts();

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\n===== AUTOCLOSEABLE DEMO =====");

        try (
                CustomResource resource1 =
                        new CustomResource("Resource 1");

                CustomResource resource2 =
                        new CustomResource("Resource 2")
        ) {

            resource1.execute();
            resource2.execute();

        }

        System.out.println("\n===== PROGRAM COMPLETED =====");
    }
}