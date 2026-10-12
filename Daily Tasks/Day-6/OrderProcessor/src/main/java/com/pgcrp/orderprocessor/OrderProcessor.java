
package com.pgcrp.orderprocessor;

public class OrderProcessor {

    public void processOrder(String quantityInput, int availableStock)
            throws InsufficientStockException {

        try {
            int quantity = Integer.parseInt(quantityInput);

            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Order quantity must be greater than zero."
                );
            }

            if (availableStock < 0) {
                throw new IllegalArgumentException(
                        "Available stock cannot be negative."
                );
            }

            if (quantity > availableStock) {
                throw new InsufficientStockException(
                        "Requested quantity: " + quantity
                                + ", available stock: " + availableStock
                );
            }

            System.out.println("Order processed successfully!");
            System.out.println("Quantity: " + quantity);

        } catch (NumberFormatException e) {
            // Exception chaining: preserve the original parsing error.
            throw new InvalidQuantityException(
                    "Quantity must be a valid whole number.", e
            );

        } finally {
            // Runs whether processing succeeds or fails.
            System.out.println("AUDIT: Order processing attempt finished.");
        }
    }
}
