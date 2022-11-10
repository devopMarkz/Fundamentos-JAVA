package exerciciosJava;
import java.util.Scanner;
import java.util.Locale;

public class MiddleLetter {

	// C�digo principal
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);

		System.out.println("Escreva uma palavra: ");
		String palavra = sc.nextLine();
		
		caractMeio(palavra);
		
		sc.close();

	}
	
	// Fun��o do c�digo principal
	public static void caractMeio (String palavra) {
		
		// Se a quantidade de caracteres da cadeia for PAR:
		if (palavra.length() % 2 == 0) {
		System.out.print(palavra.charAt(palavra.length()/2-1));
		System.out.print(palavra.charAt(palavra.length()/2) + " ");
		}
		
		// Se a quantidade de caracteres da cadeia for �MPAR:
		else {
			System.out.print(palavra.charAt(palavra.length()/2) + " ");
		}
	}

}
