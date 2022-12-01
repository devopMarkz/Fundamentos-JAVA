package exercicios;

import java.util.Scanner;
import java.util.Locale;

public class Exe1 {

	public static void main(String[] args) {
		
		// Criando a função replace sem usar o próprio replace

		Locale.setDefault(Locale.getDefault());
		Scanner sc = new Scanner (System.in);
		
		String nome = "Marcos André Costa da Silva";

		System.out.print("Digite um caractere que deseja trocar no texto: ");
		char letra = sc.next().charAt(0);
		
		System.out.print("Por que letra deseja realizar a troca? ");
		char letraTrocar = sc.next().charAt(0);	
		
		System.out.println(trocaCaractere(nome, letra, letraTrocar));
		
		sc.close();

	}
	
	// Função que simula o replace
	public static String trocaCaractere (String nome, char letra, char trocarLetra) {
		
		StringBuilder retorno = new StringBuilder(); // Objeto para retornar a String do nome com as trocas de caractere
		char[] guardar = new char [nome.length()]; // Transformando String para caractere e armazenando no vetor
		
		for (int i = 0; i < nome.length(); i++) {
			guardar[i] = nome.charAt(i); // Armazenamento de caractere no vetor
		} 
		
		for (int i = 0; i < guardar.length; i++) {
			if (letra == guardar[i]) guardar[i] = trocarLetra; // Trocando a letra do texto pela pretendida
			retorno.append(guardar[i]); // Concatenando os caracteres para transformar de volta em String
		}
		
		return retorno.toString();
		
	} 

}
