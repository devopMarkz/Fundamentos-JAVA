package application;

import java.io.File;
import java.util.Scanner;

import entities.ContactBook;

public class Main {
	
	// Arquivos dos contatos
	public static File contactBookFile = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\FilesExe2_AgendaDeContatos\\contactFile\\contactBook.csv");
	public static File deletedContactsFile = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\FilesExe2_AgendaDeContatos\\contactFile\\deletedContacts.csv");
	private static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args) {
		Phone phone = new Phone(new ContactBook(), introduction());
		phone.chosenOption();
	}
	
	public static int introduction () {
		System.out.print("**************** WELCOME TO YOUR CONTACT BOOK! ****************\n");
		System.out.println("Choose the options below to continue using the contact book:");
		System.out.print("1: Access agenda | 2: Add contact | 3: Delete contact | 4: Deleted contacts | 5: Exit the application -> ");
		
		return input.nextInt();
	}

}
