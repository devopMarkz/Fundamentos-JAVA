package application;

import java.util.Scanner;

import entities.ContactBook;

public class Program {

	public static void main(String[] args) {
		
		Phone phone = new Phone(new ContactBook(), introduction());
		phone.chosenOption();

	}
	
	public static int introduction () {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("**************** WELCOME TO YOUR CONTACT BOOK! ****************\n");
		System.out.println("Choose the options below to continue using the contact book:");
		System.out.print("1: Access agenda | 2: Add contact | 3: Delete contact | 4: Deleted contacts | 5: Exit the application -> ");
		
		return sc.nextInt();
		
	}

}
