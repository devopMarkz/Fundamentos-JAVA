package entities;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

	private List<Contact> contactList = new ArrayList<>();
	
	// Construtores da classe
	
	public ContactBook() {
	}

	// Métodos getters and setters
	
	public List<Contact> getContactList() {
		return contactList;
	}
	
	 // Métodos da classe
	
	public void addContact (Contact contact) {
		contactList.add(contact);
	}

}
