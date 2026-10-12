
package com.pgcrp.orderprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderProcessorApplication.class, args);

        OrderProcessor processor = new OrderProcessor();

        // Test 1: Valid order
        testOrder(processor, "3", 10);

        // Test 2: Invalid quantity (chained exception)
        testOrder(processor, "abc", 10);

        // Test 3: Insufficient stock
        testOrder(processor, "20", 5);

        // Test 4: Unchecked exception for zero quantity
        testOrder(processor, "0", 10);
    }

    private static void testOrder(
            OrderProcessor processor,
            String quantity,
            int stock) {

        try {
            System.out.println("\n--- New Order ---");
            processor.processOrder(quantity, stock);

        } catch (InvalidQuantityException | InsufficientStockException e) {
            System.out.println("Order failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
