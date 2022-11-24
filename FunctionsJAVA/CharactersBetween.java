package exercicios;

import java.util.Scanner;
import java.util.Locale;

public class CharactersBetween {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Escreva um método Java para imprimir caracteres entre dois caracteres (ou seja, A a P )");
		
		System.out.print("Deseja imprimir quantos caracteres por linha? ");
		int charLine = sc.nextInt();
		
		System.out.print("Escreva o primeiro caractere: ");
		char ch1 = Character.toLowerCase(sc.next().charAt(0));
		
		System.out.print("Escreva o segundo caractere: ");
		char ch2 = Character.toLowerCase(sc.next().charAt(0));
		
		caracteres(ch1, ch2, charLine);

		
		sc.close();

	}
	
	public static void caracteres (char ch1, char ch2, int charLine) {
		
		for (int i = 0; ch1 < ch2; ch1++, i++) {
			if (i % charLine == 0) System.out.println("");
			System.out.print(ch1 + " ");
		}
		
	}
	
}