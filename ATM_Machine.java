package task_03_ATM_interface;

import java.util.Scanner;

class BankAccount {
	private double balance;

	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.printf("Successfully deposited Rs.%.2f. "
					+ "\nCurrent balance is Rs.%.2f.\n", amount, balance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
			System.out.printf("Successfully withdrew Rs.%.2f.\n Current balance is Rs.%.2f.\n", amount, balance);
		} else {
			System.out.println("Withdrawal amount exceeds the current balance or is invalid.");
		}
	}

	public void checkBalance() {
		System.out.printf("Current balance: Rs.%.2f\n", balance);
	}
}

public class ATM_Machine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankAccount account = new BankAccount(1000); 
		while (true) {
			System.out.println("     *** Welcome to the ATM. *** \n");
			System.out.println("     ---- Choose an Options ---\n");
			System.out.println("1: Withdraw");
			System.out.println("2: Deposit");
			System.out.println("3: Check Balance");
			System.out.println("4: Exit\n\n");
			System.out.println(" Enter an option : ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: // Withdraw
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scanner.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 2: // Deposit
				System.out.print("Enter amount to deposit: ");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				break;
			case 3: // Check Balance
				account.checkBalance();
				break;
			case 4: // Exit
				System.out.println("Thank you for using the ATM.");
				System.out.println("      ### GoodBye ###    ");
				scanner.close();
				return;
			default:
				System.out.println("Invalid option. Please enter 1, 2, 3, or 4.");
				break;
			}
			System.out.println(); // Print a blank line for readability
		}
	}
}