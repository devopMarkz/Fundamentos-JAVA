package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationException;
import model.exceptions.ReservationUpdateDatesException;

public class Program {

	public static void main(String[] args) {

		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner (System.in);
			DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			// Leitura dos dados da reserva
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Checkin date: ");
			LocalDate checkin = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Checkout date: ");
			LocalDate checkout = LocalDate.parse(sc.next(), fmt1);
			
			// A DATA DE CHECKOUT NÃO PODE VIR ANTES DA DE CHECKIN (EXCEPTIONS)
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation.toString());
	
	
			System.out.println();
			System.out.println("---------------------UPDATED DATE----------------------------");
			System.out.println();
			
			System.out.println("Enter date to update the reservation:");
			sc.nextLine();
			
			// Atualização dos dados da reserva
			System.out.print("New checkin: ");
			LocalDate newCheckinDate = LocalDate.parse(sc.next(), fmt1);
			System.out.print("New checkout: ");
			LocalDate newCheckoutDate = LocalDate.parse(sc.next(), fmt1);
			
			// NÃO PODE INSERIR DATAS ANTES DA ATUAL (EXCEPTIONS)
			// A DATA DE CHECKOUT NÃO PODE VIR ANTES DA DE CHECKIN (EXCEPTIONS)
			
			reservation.updateDates(newCheckinDate, newCheckoutDate);
			System.out.println(reservation.toString());
				
				
			sc.close();
		}
		catch (RuntimeException e) {
		System.out.println(e.getMessage());
		}
		/*catch (ReservationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch (ReservationUpdateDatesException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch (InputMismatchException e) {
			System.out.println("Entrada inesperada!");
		}
		catch (DateTimeParseException e) {
			System.out.println("Entrada inesperada!");
		}*/
		
	}
				
}