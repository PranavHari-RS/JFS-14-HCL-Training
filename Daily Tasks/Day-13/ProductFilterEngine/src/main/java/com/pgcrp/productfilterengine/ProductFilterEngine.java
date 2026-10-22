package com.pgcrp.productfilterengine;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProductFilterEngine {

    public static void main(String[] args) {

        Supplier<Product> defaultProduct = Product::createDefault;

        System.out.println("===== DEFAULT PRODUCT =====");
        System.out.println(defaultProduct.get());

        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 55000, true),
                new Product("Mouse", "Electronics", 800, true),
                new Product("Keyboard", "Electronics", 1500, false),
                new Product("Shirt", "Clothing", 1200, true),
                new Product("Mobile", "Electronics", 18000, true),
                new Product("Shoes", "Footwear", 2500, false)
        );

        Predicate<Product> priceFilter =
                product -> product.getPrice() <= 20000;

        Predicate<Product> categoryFilter =
                product -> product.getCategory().equalsIgnoreCase("Electronics");

        Predicate<Product> stockFilter = Product::isInStock;

        Predicate<Product> combinedFilter =
                priceFilter.and(categoryFilter).and(stockFilter);

        Function<Product, String> productName = Product::getName;

        Function<String, String> uppercase = String::toUpperCase;

        Function<Product, String> transform =
                productName.andThen(uppercase);

        Consumer<String> printer = System.out::println;

        System.out.println("\n===== FILTERED PRODUCTS =====");

        products.stream()
                .filter(combinedFilter)
                .map(transform)
                .forEach(printer);
    }
}