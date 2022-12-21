package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double valuePerHour;
	private Double valuePerDay;
	
	private TaxService taxService;
	
	// Construtores da classe
	
	public RentalService() {
	}

	public RentalService(Double valuePerHour, Double valuePerDay, TaxService taxService) {
		this.valuePerHour = valuePerHour;
		this.valuePerDay = valuePerDay;
		this.taxService = taxService;
	}
	
	// Métodos getters and setters
	
	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Double getValuePerDay() {
		return valuePerDay;
	}

	public void setValuePerDay(Double valuePerDay) {
		this.valuePerDay = valuePerDay;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	// Métodos da classe
	
	public void processInvoice(CarRental carRental) {
		double minutes = Duration.between(carRental.getStartDate(), carRental.getFinalDate()).toMinutes();
		double hours = minutes / 60.0;
		
		double basicPayment = (hours <= 12.0)? valuePerHour * Math.ceil(hours) : valuePerDay * Math.ceil(hours / 24.0);
		double tax = taxService.getTax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

}
