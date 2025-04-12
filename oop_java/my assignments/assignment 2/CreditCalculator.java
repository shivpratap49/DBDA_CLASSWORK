package assginment2;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter initial balance (initial amount): ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Enter total items charged by customer this month: ");
        int chargeAmount = scanner.nextInt();
        double creditAmount = 0;
        while (true) {
            System.out.print("Enter total credits applied to customer's account this month: ");
            creditAmount = scanner.nextInt();
            break;
        }

        double newBalance = initialBalance + chargeAmount - creditAmount;

        if (newBalance > 10000.0) { // assuming 10,000 as the allowed limit
            System.out.println("Credit limit exceeded");
        } else {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Initial Balance: $" + String.format("%.2f", initialBalance));
            System.out.println("New Balance: $" + String.format("%.2f", newBalance));

            if (newBalance > 10000.0) {
                System.out.println("Credit limit exceeded");
            }
        }

        scanner.close();
    }
}

