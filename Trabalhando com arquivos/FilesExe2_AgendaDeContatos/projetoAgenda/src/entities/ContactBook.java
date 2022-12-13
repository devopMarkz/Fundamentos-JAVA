package entities;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

	private List<Contact> contactList = new ArrayList<>();
	private List<Contact> deletedContact = new ArrayList<>();
	
	// Construtores da classe
	
	public ContactBook() {
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
