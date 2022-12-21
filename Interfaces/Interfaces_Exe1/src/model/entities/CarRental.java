package model.entities;

import java.time.LocalDateTime;

public class CarRental {
	
	private LocalDateTime startDate;
	private LocalDateTime finalDate;
	
	private Vehicle vehicle;
	private Invoice invoice;
	
	// Construtores da classe
	
	public CarRental(){
	}
	
	public CarRental(LocalDateTime startDate, LocalDateTime finalDate, Vehicle vehicle) {
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.vehicle = vehicle;
	}
	
	// Métodos getters and setters
	
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDateTime finalDate) {
		this.finalDate = finalDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
