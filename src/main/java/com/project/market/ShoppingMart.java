package com.project.market;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingMart {

    private static final Map<String, Double> productCatalogs = new LinkedHashMap<>();
    private static final List<String> carts = new ArrayList<>();

    public static void viewProducts() {
        System.out.println("\n==========================");
        System.out.println("🛒 Available Products:");
        System.out.println("==========================");
        for (Map.Entry<String, Double> product : productCatalogs.entrySet()) {
            System.out.printf("✔ %s - $%.2f%n", product.getKey(), product.getValue());
        }
        System.out.println();
    }

    public static void addProducts(String productName) {
        if (productCatalogs.containsKey(productName)) {
            carts.add(productName);
            System.out.println("✅ '" + productName + "' has been added to your cart.");
        } else {
            System.out.println("❌ Sorry, we don't have '" + productName + "' in our store.");
        }
    }

    public static void viewCart() {
        System.out.println("\n==========================");
        System.out.println("🛍️  Your Shopping Cart:");
        System.out.println("==========================");
        if (carts.isEmpty()) {
            System.out.println("Your cart is currently empty. 🛒 Try adding some products.");
        } else {
            double total = 0.0;
            for (String item : carts) {
                double price = productCatalogs.get(item);
                total += price;
                System.out.printf("- %s ($%.2f)%n", item, price);
            }
            System.out.printf("🧾 Total so far: $%.2f%n", total);
        }
        System.out.println();
    }

    public static void checkOut() {
        System.out.println("\n==========================");
        System.out.println("💳 Checkout Summary:");
        System.out.println("==========================");
        if (carts.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
        } else {
            double total = 0.0;
            for (String item : carts) {
                total += productCatalogs.get(item);
            }
            System.out.printf("✅ Total Amount to Pay: $%.2f%n", total);
            System.out.println("🎉 Thank you for shopping with us!");
            carts.clear();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("🛍️  Welcome to Femi Shop!");
        System.out.println("==================================");

        productCatalogs.put("Apple", 34.44);
        productCatalogs.put("Banana", 55.55);
        productCatalogs.put("Chocolate", 5.64);
        productCatalogs.put("A4 Paper", 100.23);

        while (true) {
            System.out.println("\n📋 Main Menu:");
            System.out.println("1️⃣  View All Products");
            System.out.println("2️⃣  Add Product to Cart");
            System.out.println("3️⃣  View Your Cart");
            System.out.println("4️⃣  Checkout");
            System.out.println("5️⃣  Exit");
            System.out.print("👉 Please select an option (1-5): ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❗ Invalid input! Please enter a number between 1 and 5.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 ->
                    viewProducts();
                case 2 -> {
                    System.out.print("🛒 Enter the name of the product you want to add: ");
                    String productName = scanner.nextLine().trim();
                    addProducts(productName);
                }
                case 3 ->
                    viewCart();
                case 4 ->
                    checkOut();
                case 5 -> {
                    System.out.println("\n👋 Goodbye! See you next time.");
                    scanner.close();
                    return;
                }
                default ->
                    System.out.println("❗ Invalid option. Please enter a number between 1 and 5.");
            }
        }
    }

}
