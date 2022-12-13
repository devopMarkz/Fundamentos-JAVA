package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Main;

public class ContactBook {

	private List<Contact> contactList = new ArrayList<>();
	private List<Contact> deletedContact = new ArrayList<>();
	
	// Construtores da classe
	
	public ContactBook() {
		try (Scanner readingContactListFile = new Scanner (new BufferedReader(new FileReader(Main.contactBookFile)));
			 Scanner readingDeletedContactsFile = new Scanner (new BufferedReader(new FileReader(Main.deletedContactsFile)))){
			
			while(readingContactListFile.hasNextLine()) { // Preenche a lista de contatos a partir de contactBook.csv
				String[] contact = readingContactListFile.nextLine().split(",");
				contactList.add(new Contact(contact[0], contact[1]));
			}
			
			while(readingDeletedContactsFile.hasNextLine()) { // Preenche a lista de contatos deletados a partir de deletedContacts.csv
				String[] contact = readingDeletedContactsFile.nextLine().split(",");
				deletedContact.add(new Contact(contact[0], contact[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Métodos getters and setters
	
	public List<Contact> getContactList() {
		return contactList;
	}

	public List<Contact> getDeletedContact() {
		return deletedContact;
	}
	
	 // Métodos da classe
	
	public void addContact (Contact contact) {
		contactList.add(contact);
	}
	
	public void removeContact (Contact contact) {
		contactList.remove(contact);
		deletedContact.add(contact);
	}
	
	public void recoverContact (Contact contact) {
		Contact contactRecover = deletedContact.stream().filter(x -> x.getName().equals(contact.getName()) && x.getPhoneNumber() == contact.getPhoneNumber()).findFirst().orElse(null);
		contactList.add(contactRecover);
	}

}
