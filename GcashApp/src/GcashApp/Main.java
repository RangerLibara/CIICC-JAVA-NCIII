package GcashApp;

import java.util.Scanner;

public class Main {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        UserAuthentication auth = new UserAuthentication();
	        CheckBalance balanceChecker = new CheckBalance();
	        Cashin cashin = new Cashin();
	        CashTransfer transfer = new CashTransfer();
	        Transactions transactions = new Transactions();

	        System.out.println("Welcome to GcashApp");
	        System.out.print("Enter Email: ");
	        String email = scanner.nextLine();
	        System.out.print("Enter PIN: ");
	        String pin = scanner.nextLine();

	        int userId = auth.login(email, pin);
	        if (userId == -1) {
	            System.out.println("Invalid credentials. Exiting...");
	            return;
	        }

	        while (true) {
	            System.out.println("\nChoose an option:");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Cash In");
	            System.out.println("3. Transfer Money");
	            System.out.println("4. View Transactions");
	            System.out.println("5. Logout");
	            System.out.print("Enter choice: ");
	            int choice = scanner.nextInt();
	            
	            switch (choice) {
	                case 1:
	                    double balance = balanceChecker.checkBalance(userId);
	                    System.out.println("Your balance: PHP " + balance);
	                    break;
	                case 2:
	                    System.out.print("Enter amount to cash in: ");
	                    double amount = scanner.nextDouble();
	                    cashin.cashin(userId, amount);
	                    break;
	                case 3:
	                    System.out.print("Enter recipient ID: ");
	                    int recipientId = scanner.nextInt();
	                    System.out.print("Enter amount to transfer: ");
	                    double transferAmount = scanner.nextDouble();
	                    transfer.cashTransfer(userId, recipientId, transferAmount);
	                    break;
	                case 4:
	                    transactions.viewUserAll(userId);
	                    break;
	                case 5:
	                    auth.logout(userId);
	                    System.out.println("Logged out successfully.");
	                    return;
	                default:
	                    System.out.println("Invalid choice, try again.");
	            }
	        }
	    }


}
