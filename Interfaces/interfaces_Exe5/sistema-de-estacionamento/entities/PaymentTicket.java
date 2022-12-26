package entities;

import java.time.LocalDateTime;

public class PaymentTicket {
	
	private Double basicPayment;
	private LocalDateTime entryMoment;
	private LocalDateTime exitMoment;
	
	// Construtores da classe
	
	public PaymentTicket() {
	}

	public PaymentTicket(Double basicPayment, LocalDateTime entryMoment, LocalDateTime exitMoment) {
		this.basicPayment = basicPayment;
		this.entryMoment = entryMoment;
		this.exitMoment = exitMoment;
	}
	
	// Getters e setters

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public LocalDateTime getEntryMoment() {
		return entryMoment;
	}

	public void setEntryMoment(LocalDateTime entryMoment) {
		this.entryMoment = entryMoment;
	}

	public LocalDateTime getExitMoment() {
		return exitMoment;
	}

	public void setExitMoment(LocalDateTime exitMoment) {
		this.exitMoment = exitMoment;
	}
}
