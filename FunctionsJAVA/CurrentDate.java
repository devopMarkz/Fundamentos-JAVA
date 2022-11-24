package exercicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Exe4 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Escreva um método Java para exibir a data e hora atuais.
		
		dataAtual();
		
		sc.close();

	}
	
	public static void dataAtual () {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy, HH:mm");
		LocalDateTime var = LocalDateTime.now();
		System.out.println(var.format(fmt1));
		
	}
	
}