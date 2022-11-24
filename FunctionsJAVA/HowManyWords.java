package exercicios;

import java.util.Scanner;
import java.util.Locale;

public class Exe2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Variáveis do sistema:
		
		System.out.print("Escreva uma frase para que o programa contabilize a quantidade de palavras dentro dela: ");
		String frase = sc.nextLine();
		
		System.out.println("O número de palavras dentro da frase é de: " + howManyWords(frase));
		
		sc.close();

	}
	
	public static int howManyWords (String frase) {
		String[] palavras = frase.split(" ");
		return palavras.length;
	}
	
}