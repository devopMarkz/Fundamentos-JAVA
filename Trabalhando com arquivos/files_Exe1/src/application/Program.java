package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
			Locale.setDefault(Locale.US);
			File file = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\fileData\\in.csv");
			registerProducts(file);
			
	}
	
	private static void registerProducts(File file) throws InputMismatchException {
		try (Scanner sc = new Scanner (System.in); BufferedWriter bw = new BufferedWriter(new FileWriter (file, true))){
			
			System.out.println("Deseja adicionar dados ao seu arquivo? ");
			char resposta = Character.toLowerCase(sc.next().charAt(0));
			
			if (resposta == 's') {
			
				System.out.print("Deseja cadastrar quantos produtos? ");
				int productNumber = sc.nextInt();
				sc.nextLine();
				
				for (int i = 0; i < productNumber; i++) { // Populando o arquivo com dados de produtos
					sc.nextLine();
					System.out.print("Name: ");
					String name = sc.nextLine();
					
					System.out.print("Price: ");
					double price = sc.nextDouble();
							
					System.out.print("Quantity: ");
					int quantity = sc.nextInt();
					
					bw.write(new Product(name, price, quantity).toString());
					bw.newLine();
				}
			}
			else System.out.println("Procedimento encerrado! ");
		} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
		} catch (RuntimeException e) {
				System.out.println("Entrada inválida!");
				e.printStackTrace();
		}
		
	}
	
}
