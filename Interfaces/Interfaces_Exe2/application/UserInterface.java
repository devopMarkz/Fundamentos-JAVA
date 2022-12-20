package application;

import java.util.Scanner;

import model.entities.Contact;
import model.entities.ContactBook;

public record UserInterface(
		ContactBook contactBook,
		Integer choiceInit) {
	
	// Edição de cores do texto
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	private static Scanner input = new Scanner (System.in); // Scanner de entrada de dados
	
	// Métodos da classe Record
	
	public void startProgram() { // Decide o método a ser executado de acordo com a escolha inicial do usuário
		switch (choiceInit) {
		case 1: {
			acessContactBook();
			break;
		}
		case 2: {
			addContact();
			break;
		}
		case 3: {
			removeContact();
			break;
		}
		case 4: {
			acessDeletedContactBook();
			break;
		}
		default:
			break;
		}
	}
	
	private void acessContactBook() { // Opção 1 - Mostrar os contatos salvos na lista
		System.out.println("\n--------------- CONTACT LIST ---------------\n");
		
		for (Contact contact : contactBook.getContactList()) {
			System.out.println("\t       " + ANSI_GREEN + contact + ANSI_RESET);
		}
		
		System.out.println("\n------------- END CONTACT LIST -------------\n");
	}
	
	private void addContact() { // Opção 2 - Salvar contatos na lista
		try {
			System.out.print("Okay, here we go! \nHow many contacts you want to add to your contact list? ");
			int amountOfContacts = input.nextInt();
			
			input.nextLine();
			
			for (int i = 0; i < amountOfContacts; i++) { // Add contacts to contactList
				System.out.print("Name: ");
				String name = input.nextLine().trim(); // trim() para não prejudicar a leitura do arquivo .csv com espaços em branco
				System.out.println("Phone number (Area code + phone Number): ");
				String phoneNumber = input.nextLine().trim();
				
				contactBook.addContact(new Contact(name, phoneNumber));
			}
		} catch (RuntimeException e) {
			System.err.println("Número inválido! Nenhum contato foi adicionado à lista.");
		}
	}
	
	private void removeContact() { // Opção 3 - Remover contato da lista
		System.out.print("Okay, here we go! \nWhich contact do you want to remove from the contact list? \nName: ");
		String name = input.nextLine().trim();
		System.out.print("Phone number (Area code + phone Number): ");
		String phoneNumber = input.nextLine().trim();
		
		contactBook.removeContact(new Contact(name, phoneNumber));
	}
	
	private void acessDeletedContactBook() { // Opção 4 - Mostrar os contatos salvos na lista de contatos deletados
		System.out.println("\n--------------- DELETED CONTACTS LIST ---------------\n");
		
		for (Contact contact : contactBook.getDeletedContactsList()) {
			System.out.println("\t       " + ANSI_GREEN + contact + ANSI_RESET);
		}
		
		System.out.println("\n------------- END DELETED CONTACTS LIST -------------\n");
	}

}
