package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {


	private Integer number;
	private LocalDate date;
	private Double totalValue;
	
	List<Installment> installments = new ArrayList<>();
	
	// Construtores da classe
	
	public Contract() {
	}
	
	public Contract(int number, LocalDate date, double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	// Métodos getters and setters

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	// Métodos da classe
	
	@Override
	public String toString() {
		return "Number of contract: " + number 
				+ ", Start date: " + date
				+ ", Total value: " + totalValue;
	}
	
	public String plotSummary() {
		StringBuilder almost = new StringBuilder();
		
		for (Installment installment : installments) {
			almost.append(installment.toString() + "\n");
		}
		
		return almost.toString();
	}
	
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	
}
