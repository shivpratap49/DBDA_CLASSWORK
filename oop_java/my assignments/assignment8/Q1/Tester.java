package assignment8.Q1;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack_Interface selectedStack = null; // Ensure this matches your Stack interface name

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 -- Choose Fixed Stack");
            System.out.println("2 -- Choose Growable Stack");
            if (selectedStack != null) {
                System.out.println("3 -- Push data");
                System.out.println("4 -- Pop data");
            }
            System.out.println("5 -- Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (selectedStack == null) {
                        selectedStack = new FixedStack();
                        System.out.println("Fixed Stack chosen.");
                    } else {
                        System.out.println("No change allowed! Stack already chosen.");
                    }
                    break;

                case 2:
                    if (selectedStack == null) {
                        selectedStack = new GrowableStack();
                        System.out.println("Growable Stack chosen.");
                    } else {
                        System.out.println("No change allowed! Stack already chosen.");
                    }
                    break;

                case 3:
                    if (selectedStack != null) {
                        try {
                            System.out.print("Enter Employee ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Employee Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Employee Salary: ");
                            double salary = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline

                            Employee emp = new Employee(id, name, salary);
                            selectedStack.push(emp);
                        } catch (Exception e) {
                            System.out.println("Invalid input! Please enter valid data.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    } else {
                        System.out.println("NO stack chosen !!!");
                    }
                    break;

                case 4:
                    if (selectedStack != null) {
                        Employee emp = selectedStack.pop();
                        if (emp != null) {
                            System.out.println("Popped: " + emp);
                        }
                    } else {
                        System.out.println("NO stack chosen !!!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}