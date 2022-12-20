package application;

import java.util.Scanner;

import model.entities.ContactBook;
import model.services.SearchContactsInArchives;

public class Main {
	
	private static Scanner input = new Scanner (System.in);
	
	public static int introduction() {
		System.out.println("**************** WELCOME TO YOUR CONTACT BOOK! ****************\n");
		System.out.println("Choose the options below to continue using the contact book:");
		System.out.print("1: Access contact book | 2: Add contact | 3: Remove contact | 4: access deleted contact book | 5: Exit the application -> ");
		
		return input.nextInt();
	}

	public static void main(String[] args) {
		// Injeção de dependência no primeiro argumento do objeto ContactBook
		UserInterface ui = new UserInterface(new ContactBook(new SearchContactsInArchives()), introduction());
		ui.startProgram();
		System.out.print("\n*************** THANK YOU FOR USING THE PROGRAM! ***************\n");
	}

}
