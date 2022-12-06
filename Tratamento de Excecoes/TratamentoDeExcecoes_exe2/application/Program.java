package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountWithdrawException;

public class Program {
	
	// Método que solicita dados da conta
	public static Account accountData () throws RuntimeException{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Enter account data%nNumber: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		
		System.out.print("Initial balance: $ ");
		double initialBalance = sc.nextDouble();
		
		System.out.print("Withdraw limit: $ ");
		double withdrawLimit = sc.nextDouble();
		
		return new Account(number, holder, initialBalance, withdrawLimit);
	}
	
	// Método para realizar saque da conta
	public static void withdrawAction (Account account) {
		Scanner sc = new Scanner (System.in);
		try {
			System.out.print("Enter ammount for withdraw: $ ");
			account.withdraw(sc.nextDouble());
			
			System.out.println("New balance: $ " + String.format("%.2f", account.getBalance()));
		}
		catch (RuntimeException exceptionObject) {
			if (exceptionObject instanceof AccountWithdrawException) System.out.println(exceptionObject.getMessage());
			else System.out.println("Entrada inesperada! O valor de saque é nulo.");
			account.withdraw(0);
		}
		
		sc.close();
	}

	public static void main(String[] args) {

		try {
			Account account = accountData();
			withdrawAction(account);
		}
		catch (RuntimeException exceptionObject) {
			System.out.println("Entrada inesperada.");
		}


	}

}
