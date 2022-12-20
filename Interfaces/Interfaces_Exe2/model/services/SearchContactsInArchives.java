package model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Contact;

public class SearchContactsInArchives implements ContactSearchService {
	
	@Override
	public List<Contact> getContactList(File contactsFile) {
		List<Contact> contactList = new ArrayList<>();
		
		try(Scanner readContacts = new Scanner(new BufferedReader(new FileReader(contactsFile)))){
			while(readContacts.hasNextLine()) {
				String[] contactsString = readContacts.nextLine().split(",");
				contactList.add(new Contact(contactsString[0], contactsString[1]));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage() + "Lista vazia!");
			e.printStackTrace();
		}

		return contactList;
	}
	
	@Override
	public List<Contact> getDeletedContactsList(File deletedContactsFile) {
		List<Contact> deletedContactsList = new ArrayList<>();
		
		try(Scanner readContacts = new Scanner(new BufferedReader(new FileReader(deletedContactsFile)))){
			while(readContacts.hasNextLine()) {
				String[] contactsString = readContacts.nextLine().split(",");
				deletedContactsList.add(new Contact(contactsString[0], contactsString[1]));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage() + "Lista vazia!");
			e.printStackTrace();
		}

		return deletedContactsList;
	}
}
