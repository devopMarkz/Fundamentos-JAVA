package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;

public class RemoveDuplicate {

	public static void main(String[] args) {
		
		/*  Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas idades.
		 *  Depois, mostrar na tela o nome da pessoa mais velha. 
		 */ 

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Quantas pessoas irá inserir na estrutura de dados? ");
		int n = sc.nextInt();
		
		Pessoa[] pessoas = new Pessoa[n];
		
		for (int i = 0; i < pessoas.length; i++) {
			sc.nextLine();
			System.out.println("Dados da " + (i+1) + "a pessoa: ");
			
			System.out.print("Nome: ");
			String name = sc.nextLine();
			
			System.out.print("Idade: ");
			int age = sc.nextInt();
			
			pessoas[i] = new Pessoa(name, age);
		}
		
		System.out.print ("PESSOA MAIS VELHA: " + oldPeople(pessoas).getName());
		
		sc.close();

	}
	
	// Função para definir a pessoa mais velha
	public static Pessoa oldPeople (Pessoa[] pessoas) {
		Pessoa old = pessoas[0];
		
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getAge() > old.getAge()) old = pessoa;
		}
		
		return old;
		
	}


}
