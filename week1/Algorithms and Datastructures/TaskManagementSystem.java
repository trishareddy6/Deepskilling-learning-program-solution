package taskmanagement;

public class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

import java.util.Scanner;

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {

    private Node head;

    // Add task at the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        System.out.println("Task added successfully.");
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node curr = head;
        System.out.println("\nTask List:");
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }

    // Search task by ID
    public void searchTask(int id) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.taskId == id) {
                System.out.println("Task Found: " + curr.task);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.task.taskId == id) {
                prev.next = curr.next;
                System.out.println("Task deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManagementSystem tms = new TaskManagementSystem();

        int choice;
        do {
            System.out.println("\n=== Task Management System ===");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Task Status: ");
                    String status = sc.nextLine();
                    tms.addTask(new Task(id, name, status));
                    break;

                case 2:
                    tms.displayTasks();
                    break;

                case 3:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    tms.searchTask(searchId);
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    tms.deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}

Output:
=== Task Management System ===
1. Add Task
2. Display Tasks
3. Search Task
4. Delete Task
5. Exit
Enter your choice: 1
Enter Task ID: 113
Enter Task Name: Design UI
Enter Task Status: pending
Task added successfully.

=== Task Management System ===
1. Add Task
2. Display Tasks
3. Search Task
4. Delete Task
5. Exit
Enter your choice: 2

Task List:
Task ID: 113, Name: Design UI, Status: pending

=== Task Management System ===
1. Add Task
2. Display Tasks
3. Search Task
4. Delete Task
5. Exit
Enter your choice: 3
Enter Task ID to search: 113
Task Found: Task ID: 113, Name: Design UI, Status: pending

=== Task Management System ===
1. Add Task
2. Display Tasks
3. Search Task
4. Delete Task
5. Exit
Enter your choice: 4
Enter Task ID to delete: 113
Task deleted.

=== Task Management System ===
1. Add Task
2. Display Tasks
3. Search Task
4. Delete Task
5. Exit
Enter your choice: 5
Exiting. Thank you!
