package model.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import model.services.ContactSearchService;

public class ContactBook {
	
	// Atributos da classe 
	
	private File contactsFile = new File("C:\\Repositório local\\ProjetoAgenda\\projetoAgenda\\src\\contactListFile\\AgendaDeContatos.csv");
	private File deletedContactsFile = new File("C:\\Repositório local\\ProjetoAgenda\\projetoAgenda\\src\\contactListFile\\AgendaDeContatosDeletados.csv");
	private List<Contact> contactList = new ArrayList<>();
	private List<Contact> deletedContactsList = new ArrayList<>();
	
	// Construtores da classe
	
	public ContactBook() {
	}
	
	public ContactBook(ContactSearchService contacts) { // Recebe uma dependência que armazena os contatos do arquivo em contactList
		this.contactList = contacts.getContactList(contactsFile);
		this.deletedContactsList = contacts.getDeletedContactsList(deletedContactsFile);
	}
	
	// Métodos getters and setters

	public File getContactsFile() {
		return contactsFile;
	}

	public List<Contact> getContactList() {
		return contactList;
	}
	
	public List<Contact> getDeletedContactsList() {
		return deletedContactsList;
	}
	
	// Métodos da classe
	
	public void addContact(Contact contact) {
		contactList.add(contact);
		updateContactListFile();
	}
	
	public void removeContact(Contact contact) {
		contactList.removeIf(x -> x.toString().equals(contact.toString()));
		deletedContactsList.add(contact);
		updateDeletedContactsListFile();
		updateContactListFile();
	}
	
	private void updateContactListFile() { // Atualiza o arquivo AgendaDeContatos.csv conforme a lista do objeto ContactBook
		try(BufferedWriter insertDataIntoCsvFile = new BufferedWriter(new FileWriter(contactsFile))) {
			for (Contact contact : contactList) {
				insertDataIntoCsvFile.write(contact.toString());
				insertDataIntoCsvFile.newLine();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void updateDeletedContactsListFile() { // Atualiza o arquivo AgendaDeContatosDeletados.csv conforme a lista do objeto ContactBook
		try(BufferedWriter insertDataIntoCsvFile = new BufferedWriter(new FileWriter(deletedContactsFile))) {
			for (Contact contact : deletedContactsList) {
				insertDataIntoCsvFile.write(contact.toString());
				insertDataIntoCsvFile.newLine();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
