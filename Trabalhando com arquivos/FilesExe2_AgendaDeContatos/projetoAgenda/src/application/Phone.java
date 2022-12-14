package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entities.Contact;
import entities.ContactBook;

public record Phone(ContactBook contactBook, Integer choiceInit) {
	
	private static Scanner input = new Scanner (System.in);
	
	public void chosenOption () {
		
		switch (choiceInit) {
		case 1: {
			accessContactBook();
			break;
		}
		case 2: {
			addContact();
			break;
		}
		/* case 3: {
			deleteContact();
			break;
		} */
		default:
			break;
		}

	}
	
	private void accessContactBook () { // 1: Acess contact book
		try (Scanner readingFile = new Scanner (new BufferedReader(new FileReader(Main.contactBookFile)))){
			System.out.println("\n**************** CONTACT LIST ****************\n");
			
			while(readingFile.hasNextLine()) {
				System.out.println("\t   " + readingFile.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	private void addContact () { // 2: Add contact (Possibilita adicionar contato ao arquivo contactBook.csv)
		try (BufferedWriter insertData = new BufferedWriter(new FileWriter(Main.contactBookFile, true))){
			System.out.print("How many contacts you want to add to the list? ");
			int numberOfContacts = input.nextInt();
			
			input.nextLine();
			
			addContactToContactBook(numberOfContacts); // Método que adiciona um objeto Contact à lista do objeto ContactBook
			
			for (Contact contact : contactBook.getContactList()) { // Passa os contatos da lista para contactBook.csv
				insertData.write(contact.toString());
				insertData.newLine();
			}
		} catch (RuntimeException e) {
			System.out.println("Invalid input!");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private void addContactToContactBook (int numberOfContacts) { // Insere objetos Contact à lista de contatos do objeto ContactBook
		for (int i = 0; i < numberOfContacts; i++) { 
			System.out.println("CONTACT #" + (i+1));
			
			System.out.print("Name: ");
			String name = input.nextLine();
			
			System.out.print("Phone number (Area code + Phone number): ");
			String phoneNumber = input.nextLine();
			
			contactBook.addContact(new Contact(name, phoneNumber));
		}
	}
}
	
	/* EM BREVE IMPLEMENTAREI A DELEÇÃO DE CONTATOS
	 * private void deleteContact() { // 3: Delete contact (deleta contatos da lista)
		
		System.out.println("Write the name and number of the contact you want to remove from the list");
		
		System.out.print("Name: ");
		String name = input.nextLine();
		
		System.out.println("Phone number (Area code + Phone number): ");
		String phoneNumber = input.nextLine();
		
		contactBook.removeContact(new Contact(name, phoneNumber));
	} */
