package javaprogramming;

public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: $" + price;
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct(sc);
                case 2 -> updateProduct(sc);
                case 3 -> deleteProduct(sc);
                case 4 -> viewInventory();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please enter 1-5.");
            }
        } while (choice != 5);

        sc.close();
    }

    static void addProduct(Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (inventory.containsKey(id)) {
            System.out.println("❗ Product ID already exists.");
            return;
        }
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product product = new Product(id, name, qty, price);
        inventory.put(id, product);
        System.out.println("✅ Product added successfully!");
    }

    static void updateProduct(Scanner sc) {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (!inventory.containsKey(id)) {
            System.out.println("❗ Product not found.");
            return;
        }

        Product product = inventory.get(id);

        System.out.print("Enter new name (" + product.getProductName() + "): ");
        String name = sc.nextLine();
        System.out.print("Enter new quantity (" + product.getQuantity() + "): ");
        int qty = sc.nextInt();
        System.out.print("Enter new price (" + product.getPrice() + "): ");
        double price = sc.nextDouble();

        product.setProductName(name);
        product.setQuantity(qty);
        product.setPrice(price);

        System.out.println("✅ Product updated successfully!");
    }

    static void deleteProduct(Scanner sc) {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        if (inventory.remove(id) != null) {
            System.out.println("🗑️ Product deleted successfully.");
        } else {
            System.out.println("❗ Product not found.");
        }
    }

    static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("📦 Inventory is empty.");
        } else {
            System.out.println("📝 Inventory List:");
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }
}
