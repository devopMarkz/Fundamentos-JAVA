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

	private static void registerProducts(File file) throws InputMismatchException {
		try (Scanner sc = new Scanner (System.in); BufferedWriter bw = new BufferedWriter(new FileWriter (file, true))){
	
			System.out.print("Deseja cadastrar quantos produtos? ");
			int productNumber = sc.nextInt();
			sc.nextLine();
			
			// Populando o arquivo com dados de produtos
			for (int i = 0; i < productNumber; i++) {
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
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Entrada inválida!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
			Locale.setDefault(Locale.US);
			File file = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\fileData\\in.csv");
			registerProducts(file);
			
	}

}
