package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import entities.ContactBook;

public record Phone(ContactBook contactBook, Integer choiceInit) {
	
	// Arquivos dos contatos
	private static File contactBookFile = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\FilesExe2_AgendaDeContatos\\contactFile\\contactBook.csv");
	private static File deletedContactsFile = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\FilesExe2_AgendaDeContatos\\contactFile\\deletedContacts.csv");
	
	public void chosenOption () {
		
		switch (choiceInit) {
		case 1: {
			accessContactBook();
		}
		default:
			break;
		}

	}
	
	private void accessContactBook () { // Permite o acesso à lista de contatos
		try (Scanner readingFile = new Scanner (new BufferedReader(new FileReader(contactBookFile)))){
			
			System.out.println("**************** LISTA DE CONTATOS ****************\n");
			
			while(readingFile.hasNextLine()) {
				System.out.println(readingFile.nextLine());
			}
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
