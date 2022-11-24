package exercicios;

import java.util.Scanner;
import java.util.Locale;

public class Exe1 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Variáveis do sistema:
		
		System.out.print("Escreva uma palavra para ter suas vogais contabilizadas: ");
		String palavra = sc.next();
		
		System.out.println("O número de vogais na palavra é: " + areVowel(palavra.toLowerCase()));
		
		
		sc.close();

	}
	
	public static int areVowel (String palavra) {
		int vowelsNumber = 0;
		
		for (int i = 0; i < palavra.length(); i++) {
			char ch = palavra.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vowelsNumber++;
			}
		}
		return vowelsNumber;
	}

}
