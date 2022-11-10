package exercises;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Sep_LettersAndNumbers {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Escreva uma frase com letras e números para separá-los"
				+ " em listas diferentes: ");
		String palavra = sc.nextLine();
		
		List <Character> letras = new ArrayList<>();
		List <Character> numeros = new ArrayList<>();
		
		textCheck(palavra, letras, numeros);
		
		System.out.print("Lista de letras: ");
		for (Character letra : letras) {
			System.out.print(letra + " ");
		}
		
		System.out.println();
		
		System.out.print("Lista de números: ");
		for (Character numero : numeros) {
			System.out.print(numero + " ");
		}
		
		sc.close();

	}
	
	// Função para checar e separar letras e números em listas diferentes
	public static void textCheck (String palavra, List <Character> letras, List <Character> numeros) {
	
		for (int i = 0; i < palavra.length(); i++) {
			
			// Percorre cada caractere da frase através do charAt + Variável de iteração (i)
			char ch = palavra.charAt(i);
			ch = Character.toUpperCase(ch);
			
			// Checa se o caractere é letra ou número
			if (ch >= 'A' && ch <= 'Z') letras.add(ch);
			else if (ch >= '1' && ch <= '9') numeros.add(ch);
			else;
			
		}
		
	}
	

}
