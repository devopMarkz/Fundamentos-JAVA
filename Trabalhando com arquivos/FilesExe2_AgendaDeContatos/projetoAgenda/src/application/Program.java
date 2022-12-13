package application;

import java.util.Scanner;

import entities.ContactBook;

public class Program {

	public static void main(String[] args) {
		
		Phone phone = new Phone(new ContactBook(), introduction());
		phone.chosenOption();

	}
	
	public static int introduction () {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("**************** WELCOME TO YOUR CONTACT BOOK! ****************\n");
		System.out.println("Choose the options below to continue using the contact book:");
		
		int choiceInit;
		
		System.out.println("1: Acessar a agenda | 2: Adicionar contato | 3: Excluir contato | 4: Contatos excluídos | 5: Sair do aplicativo");
		choiceInit = sc.nextInt();
		
		sc.close();
		
		return choiceInit;
		
	}

}
