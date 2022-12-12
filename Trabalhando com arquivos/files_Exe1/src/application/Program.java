package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
			Locale.setDefault(Locale.US);
			File file = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\fileData\\in.csv");
			System.out.println(file.getParent());
			registerProducts(file);
			getFiles(file);
		
	}
	
	private static void registerProducts(File file) throws InputMismatchException {
		try (Scanner sc = new Scanner (System.in); BufferedWriter bw = new BufferedWriter(new FileWriter (file, true))){
			
			System.out.print("Deseja adicionar dados ao seu arquivo? ");
			char resposta = Character.toLowerCase(sc.next().charAt(0));
			
			if (resposta == 's') {
			
				System.out.print("Deseja cadastrar quantos produtos? ");
				int productNumber = sc.nextInt();
				
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
	
	private static void getFiles (File file) {
		new File(file.getParent() + "\\out").mkdir();
		try (Scanner sc = new Scanner (new BufferedReader(new FileReader(file))); BufferedWriter bw = new BufferedWriter (new FileWriter(file.getParent() + "\\out\\summary.csv", false))){
			
			List<String> productList = new ArrayList<>();
			
			while (sc.hasNextLine()) {
				productList.add(sc.nextLine());
			}
			
			for (int i = 0; i < productList.size(); i++) {
				String[] product = productList.get(i).split(",");
				double cont = Double.parseDouble(product[1]) * Double.parseDouble(product[2]);
				bw.write(product[0] + ", " + cont);
				bw.newLine();
			}

			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
