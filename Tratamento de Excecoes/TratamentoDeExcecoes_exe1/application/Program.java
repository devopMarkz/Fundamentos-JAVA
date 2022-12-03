package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Checkin date: ");
		LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
		
		System.out.print("Checkout date: ");
		LocalDate checkout = LocalDate.parse(sc.next(), fmt1);
		
		// A DATA DE CHECKOUT NÃO PODE VIR ANTES DA DE CHECKIN (EXCEPTIONS)
		Reservation reservation;
		if (!checkout.isAfter(checkin)) {
			System.err.println("A data de checkout não pode vir antes do checkin!");
		}
		else {
			reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation.toString());
		}

		System.out.println();
		System.out.println("---------------------UPDATED DATE------------------------------");
		System.out.println();
		
		System.out.println("Enter date to update the reservation:");
		
		System.out.print("New checkin: ");
		LocalDate newCheckinDate = LocalDate.parse(sc.next(), fmt1);
		
		System.out.print("New checkout: ");
		LocalDate newCheckoutDate = LocalDate.parse(sc.next(), fmt1);
		
		// NÃO PODE INSERIR DATAS ANTES DA ATUAL (EXCEPTIONS)
		// A DATA DE CHECKOUT NÃO PODE VIR ANTES DA DE CHECKIN (EXCEPTIONS)
		if (newCheckinDate.isBefore(LocalDate.now()) || newCheckoutDate.isBefore(LocalDate.now())) {
			System.err.println("Não é possível inserir datas que vem antes da atual!");
		}
		else if (!newCheckoutDate.isAfter(newCheckinDate)) {
			System.err.println("A data de checkout não pode vir antes do checkin!");
		}
		else {
			reservation = new Reservation(roomNumber, newCheckinDate, newCheckoutDate);
			reservation.updateDates(newCheckinDate, newCheckoutDate);
			System.out.println(reservation.toString());
		}
		
		sc.close();

	}

}
