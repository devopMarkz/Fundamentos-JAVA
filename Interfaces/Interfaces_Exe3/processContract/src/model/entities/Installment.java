package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	private LocalDate dueDate;
	private Double amount;
	
	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Construtores da classe
	
	public Installment() {
	}
	
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	// Métodos getters and setters
	
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	// Métodos da classe
	
	@Override 
	public String toString() {
		return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
	}

}
