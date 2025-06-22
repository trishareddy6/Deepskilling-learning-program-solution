package employeemanagement;

public class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
    }
}

package employeemanagement;

import java.util.Scanner;

public class EmployeeManagementSystem {

    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    public static void addEmployee(Scanner sc) {
        if (count >= MAX_EMPLOYEES) {
            System.out.println("Employee array is full.");
            return;
        }

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Position: ");
        String position = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees[count++] = new Employee(id, name, position, salary);
        System.out.println("Employee added successfully!");
    }

    public static void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\nList of Employees:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void searchEmployee(Scanner sc) {
        System.out.print("Enter employee ID to search: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found: " + employees[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public static void deleteEmployee(Scanner sc) {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    searchEmployee(sc);
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

Output:
=== Employee Management System ===
1. Add Employee
2. Display All Employees
3. Search Employee
4. Delete Employee
5. Exit
Enter your choice: 1
Enter ID: 111
Enter Name: Trisha
Enter Position: Develpoer
Enter Salary: 60000
Employee added successfully!

=== Employee Management System ===
1. Add Employee
2. Display All Employees
3. Search Employee
4. Delete Employee
5. Exit
Enter your choice: 2

List of Employees:
ID: 111, Name: Trisha, Position: Develpoer, Salary: ₹60000.0

=== Employee Management System ===
1. Add Employee
2. Display All Employees
3. Search Employee
4. Delete Employee
5. Exit
Enter your choice: 3
Enter employee ID to search: 111
Employee found: ID: 111, Name: Trisha, Position: Develpoer, Salary: ₹60000.0

=== Employee Management System ===
1. Add Employee
2. Display All Employees
3. Search Employee
4. Delete Employee
5. Exit
Enter your choice: 4
Enter employee ID to delete: 111
Employee deleted successfully.

=== Employee Management System ===
1. Add Employee
2. Display All Employees
3. Search Employee
4. Delete Employee
5. Exit
Enter your choice: 5
Exiting. Thank you!
