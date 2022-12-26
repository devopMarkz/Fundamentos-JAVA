package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.ParkingCharge;
import entities.Vehicle;
import services.ParkingSystemFeeService;
import services.PaymentTicketProcessingService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.print("Nome do cliente: ");
		String name = sc.nextLine();
		System.out.print("CPF do cliente: ");
		String cpf = sc.next();
		sc.nextLine();
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.print("Placa do carro: ");
		String licensePlate = sc.next();
		sc.nextLine();
		
		ParkingCharge pc = new ParkingCharge(new Client(name, cpf, new Vehicle(carModel, licensePlate)));
		
		System.out.print("Horário de entrada (dd/MM/yyyy HH:mm): ");
		LocalDateTime entryMoment = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Horário de saída (dd/MM/yyyy HH:mm): ");
		LocalDateTime exitMoment = LocalDateTime.parse(sc.nextLine(), fmt);
		
		PaymentTicketProcessingService ps = new PaymentTicketProcessingService(new ParkingSystemFeeService());
		
		ps.processPaymentTicket(pc, entryMoment, exitMoment);
		
		System.out.println("\nNOTA FISCAL: ");
		System.out.println(pc.toString());
		
		sc.close();
		
	}

}
