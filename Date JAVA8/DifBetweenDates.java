package datasExe;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DifferenceBtDates {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Escreva um programa Java para obter ano e meses entre duas datas
		
		LocalDate data1 = LocalDate.now();
		
		LocalDate data2 = LocalDate.parse("25/09/2002", fmt1);
		
		Period dif = Period.between(data2, data1);
		
		System.out.println("A diferença é de " + dif.getYears() + " anos e " + dif.getMonths() + " meses");
		
		sc.close();

	}

}