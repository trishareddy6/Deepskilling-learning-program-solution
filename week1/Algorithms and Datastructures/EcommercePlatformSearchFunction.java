package ecommerce;

public class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

package ecommerce;
import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    // Linear Search (O(n))
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (O(log n)) — requires sorted array
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Sample product data
        Product[] products = {
            new Product(105, "Keyboard", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(102, "Book", "Stationery"),
            new Product(104, "Mobile", "Electronics")
        };

        int searchId = 103;

        // Linear Search
        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, searchId);
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Binary Search
        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, searchId);
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}

output:
Linear Search Result:
Product ID: 103, Name: Shoes, Category: Fashion

Binary Search Result:
Product ID: 103, Name: Shoes, Category: Fashion
