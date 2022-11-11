package exercises;
import java.util.Scanner;
import java.util.Locale;

public class CheckPair {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite um número inteiro qualquer para saber se cada dígito é par: ");
		Integer number = sc.nextInt();
		
		if (itsPair(number)) System.out.println("Verdadeiro!");
		else System.out.println("Falso!");
		
		sc.close();
}
	
	public static boolean itsPair (Integer number) {
		
		// Transformei o número para o tipo String, para poder obter a quant. de digitos nele, assim...
		// ... à usando como limite do laço for.
		for (int i = 0; i < number.toString(number).length(); i++) {
			
			// Transformei o número num caractere para pegar de um por um através do charAt (i)
			char p1 = Integer.toString(number).charAt(i);
			
			// Transformei esse único número em String...
			String p2 = Character.toString(p1);
			
			// ...Para depois poder transformá-lo em inteiro e checar se o unicode era par ou ímpar
			Integer p3 = Integer.parseInt(p2);
			
			// Se pelo menos um número for ímpar, retorna falso
			if (p3 % 2 != 0) return false;
			
		}
		
		// Caso contrário, retorna verdadeiro
		return true;
	
	}
	
}