package exercises;
import java.util.Scanner;
import java.util.Locale;

public class PasswordValidation {
	
    // Mínimo de caracteres que a senha deve ter
	public static final int TAMANHO_SENHA = 8;

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		System.out.printf("Algumas condições para digitar sua senha: %n"
				+ "1. Uma senha deve ter pelo menos oito caracteres.  %n"
				+ "2. Uma senha consiste apenas em letras e dígitos. %n"
				+ "3. Uma senha deve conter pelo menos dois dígitos. %n"
				+ "Insira uma senha: ");
                
		String senha;
		
		do {
			senha = sc.next();
			if (isValidPassword(senha)) System.out.println("Senha Válida!");
			else System.out.print("Senha inválida. Digite uma senha correta: ");
		} while (isValidPassword(senha) == false);
		
		sc.close();

	}
	

    // Funcao de validacao de senha
	public static boolean isValidPassword (String senha) {
		if (senha.length() < TAMANHO_SENHA) return false;
	
		int charCount = 0;
		int numCount = 0;
		
		for (int i = 0; i < senha.length(); i++) {
			char ch = senha.charAt(i);
			if (isLetter(ch)) charCount++;
			else if (isNumeric(ch)) numCount++;
			else return false;
		}
		
		return (charCount >= 2 && numCount >= 2);
		
	}
	
    // Auxilia na contagem da quantia de caracteres
	public static boolean isLetter (char ch) {
		ch = Character.toUpperCase(ch);
		return (ch >='A' && ch <= 'Z');
	}
	
    // Auxilia na contagem da quantia de numeros
	public static boolean isNumeric (char ch) {
		ch = Character.toUpperCase(ch);
		return (ch >='0' && ch <= '9');
	}
	

}