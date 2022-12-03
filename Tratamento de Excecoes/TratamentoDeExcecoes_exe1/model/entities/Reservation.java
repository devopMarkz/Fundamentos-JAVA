package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	// Formatação de data
	
	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Construtores da classe
	
	public Reservation () {
	}
	
	public Reservation (int roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	// Métodos getters and setters

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	// Métodos da classe
	
	public long duration () {
		Duration dt = Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay());
		return dt.toDays();
	}
	
	public String updateDates (LocalDate newCheckinDate, LocalDate newCheckoutDate) {
		if (newCheckinDate.isBefore(LocalDate.now()) || newCheckoutDate.isBefore(LocalDate.now())) {
			return "Não é possível inserir datas que vem antes da atual!";
		}
		if (!newCheckoutDate.isAfter(newCheckinDate)) {
			return "A data de checkout não pode vir antes do checkin!";
		}
		this.checkin = newCheckinDate;
		this.checkout = newCheckoutDate;
		return null;
	}
	
	@Override
	public String toString () {
		return "Reservation: Room " + this.roomNumber
				+ ", checkin: " + this.checkin.format(fmt1)
				+ ", checkout: " + this.checkout.format(fmt1)
				+ ", " + this.duration() + " nights";
	}

}
