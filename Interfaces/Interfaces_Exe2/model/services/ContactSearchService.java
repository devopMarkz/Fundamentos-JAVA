package model.services;

import java.io.File;
import java.util.List;

import model.entities.Contact;

public interface ContactSearchService {
	
	public List<Contact> getContactList(File contactsFile);
	
	public List<Contact> getDeletedContactsList(File deletedContactsFile);

}
