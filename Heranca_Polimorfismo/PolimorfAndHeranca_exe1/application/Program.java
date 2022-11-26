package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;
import utilitarios.Util;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Formatação de data
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// Variáveis do programa
		List <Produto> listaProdutos = new ArrayList <>(); // Lista de produtos
		Produto produto; // Objeto produto 
		
		System.out.print("Insira a quantidade de produtos: ");
		int productQuantity = sc.nextInt();
		
		for (int i = 1; i <= productQuantity; i++) {
			
			System.out.println("Dados do produto #" + i);
			
			char resposta; // Resposta sobre o tipo do produto
			
			do {
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			resposta = Character.toLowerCase(sc.next().charAt(0));
			} while (resposta != 'c' && resposta != 'u' && resposta != 'i');
			
			// Coleta de dados do produto
			sc.nextLine();
			System.out.print("Nome: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (resposta == 'c') {
				produto = new Produto(name, price);
			}
			else if (resposta == 'u') {
				System.out.print("Taxa alfandegária: ");
				double customsFee = sc.nextDouble();
				produto = new ProdutoImportado(name, price, customsFee);
			}
			else {
				System.out.print("Data de fabricação: ");
				LocalDate manufactureDate = LocalDate.parse(sc.next(), fmt1);
				produto = new ProdutoUsado(name, price, manufactureDate);
			}
			
			listaProdutos.add(produto); // Lista para armazenar os produtos
			
		}
		
		System.out.println();
		
		System.out.println("ETIQUETAS DE PRODUTOS: ");
		System.out.println(Util.productInformation(listaProdutos));	// Exibe as informações de todos os produtos
		
		sc.close();

	}

}
