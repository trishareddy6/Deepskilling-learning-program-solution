package customerorders;

public class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: ₹" + totalPrice;
    }
}

package customerorders;

public class OrderSorting {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Helper to display orders
    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(101, "Alice", 1500.0),
            new Order(102, "Bob", 2999.5),
            new Order(103, "Charlie", 1200.0),
            new Order(104, "Diana", 4500.75),
            new Order(105, "Eve", 2300.0)
        };

        // Clone for separate sorting
        Order[] orders2 = orders1.clone();

        System.out.println("Before Sorting:");
        printOrders(orders1);

        System.out.println("\nAfter Bubble Sort (Low to High):");
        bubbleSort(orders1);
        printOrders(orders1);

        System.out.println("\nAfter Quick Sort (Low to High):");
        quickSort(orders2, 0, orders2.length - 1);
        printOrders(orders2);
    }
}

Output:
Before Sorting:
Order ID: 101, Customer: Alice, Total Price: ₹1500.0
Order ID: 102, Customer: Bob, Total Price: ₹2999.5
Order ID: 103, Customer: Charlie, Total Price: ₹1200.0
Order ID: 104, Customer: Diana, Total Price: ₹4500.75
Order ID: 105, Customer: Eve, Total Price: ₹2300.0

After Bubble Sort (Low to High):
Order ID: 103, Customer: Charlie, Total Price: ₹1200.0
Order ID: 101, Customer: Alice, Total Price: ₹1500.0
Order ID: 105, Customer: Eve, Total Price: ₹2300.0
Order ID: 102, Customer: Bob, Total Price: ₹2999.5
Order ID: 104, Customer: Diana, Total Price: ₹4500.75

After Quick Sort (Low to High):
Order ID: 103, Customer: Charlie, Total Price: ₹1200.0
Order ID: 101, Customer: Alice, Total Price: ₹1500.0
Order ID: 105, Customer: Eve, Total Price: ₹2300.0
Order ID: 102, Customer: Bob, Total Price: ₹2999.5
Order ID: 104, Customer: Diana, Total Price: ₹4500.75
