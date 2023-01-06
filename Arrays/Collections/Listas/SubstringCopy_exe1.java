import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class SubstringCopy {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		String nome = "Marcos André Costa da Silva";
		
		System.out.println("Especifique aas posições de caracteres que deseja recortar: ");
		
		System.out.print("Primeira posição: ");
		int firstLetterPosition = sc.nextInt();
		
		System.out.print("Segunda posição: ");
		int secondLetterPosition = sc.nextInt();
		
		System.out.println(copySubstring(nome, firstLetterPosition, secondLetterPosition));
		
		sc.close();

	}
	
	public static String copySubstring (String nome, int firstLetterPosition, int secondLetterPosition) {
		
		char[] letterSeparate = new char[nome.length()]; // Recolhe as letras da cadeia de caracteres
		List <Character> textClipping = new ArrayList<>(); // Armazena os caracteres recortados
		StringBuilder text = new StringBuilder(); // Objeto que armazena o texto gerado após o recorte
		
		
		for (int i = 0; i < letterSeparate.length; i++) {
			letterSeparate[i] = nome.charAt(i);
		}
		
		for (int i = firstLetterPosition; i < secondLetterPosition; i++) {
			textClipping.add(letterSeparate[i]);
		}
		
		for (int i = 0; i < textClipping.size(); i++) {
			text.append(textClipping.get(i));
		}
		
		return text.toString();
		
	}
	
}