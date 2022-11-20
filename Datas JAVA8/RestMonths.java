package datasExe;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Scanner;

public class RelogioMundial {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		// Escreva um programa Java para obter os meses restantes do ano
		
		LocalDate data1 = LocalDate.now();
		
		LocalDate data2 = LocalDate.MAX;
		
		Period bet = Period.between(data1, data2);
		
		System.out.println(bet.getMonths());
		
		sc.close();

	}

}