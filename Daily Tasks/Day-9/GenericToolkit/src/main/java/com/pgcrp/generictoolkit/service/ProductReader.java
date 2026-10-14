package com.pgcrp.generictoolkit.service;

import com.pgcrp.generictoolkit.model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {

    public static List<Product> readProducts() {

        List<Product> products = new ArrayList<>();

        InputStream inputStream =
                ProductReader.class.getClassLoader()
                        .getResourceAsStream("products.csv");

        if (inputStream == null) {
            throw new IllegalArgumentException(
                    "products.csv file not found"
            );
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        inputStream,
                        StandardCharsets.UTF_8
                ))) {

            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double price = Double.parseDouble(data[2].trim());

                products.add(new Product(id, name, price));
            }

        } catch (IOException e) {

            System.out.println(
                    "Error reading products.csv: " + e.getMessage()
            );
        }

        return products;
    }
}