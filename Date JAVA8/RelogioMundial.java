package datasExe;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class RelogioMundial {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		// Escreva um programa Java para obter o horário atual em todos os fuso horários disponíveis
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		// ZoneId.getAvailableZoneIds() é uma função que retorna uma lista com todos os fuso horários disponíveis para o Java
		for (String fusos : ZoneId.getAvailableZoneIds()) {
			LocalDateTime date = LocalDateTime.ofInstant(Instant.now(), ZoneId.of(fusos));
			System.out.println("A data e hora em " + fusos + " é: " + date.format(fmt1));
		}
		
		sc.close();

	}

}
