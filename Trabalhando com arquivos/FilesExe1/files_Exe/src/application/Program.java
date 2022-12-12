package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		getFiles();
	}
	
	private static void getFiles () {
		File file = new File("c:\\Repositório local\\Repositório local - Conceitos JAVA\\Trabalhando com arquivos\\FilesExe1\\fileData\\in.csv");
		new File(file.getParent() + "\\out").mkdir();
		
		try (Scanner sc = new Scanner (new BufferedReader(new FileReader(file))); BufferedWriter bw = new BufferedWriter(new FileWriter(file.getParent() + "\\out\\summary.csv"))) {
			
			while (sc.hasNextLine()) { // Salva os produtos do arquivo na listaProdutos
				String[] product = sc.nextLine().split(",");
				bw.write((new Product(product[0], Double.parseDouble(product[1]), Integer.parseInt(product[2])).toString())); // Add toString de Product ao arquivo out.txt
				bw.newLine();
			}			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}

