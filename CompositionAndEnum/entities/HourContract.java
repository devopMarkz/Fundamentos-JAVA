package entities;

import java.time.LocalDate;

public class HourContract {

	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;
	
	// Construtores da classe
	public HourContract () {}
	
	public HourContract(LocalDate contractDate, Double valuePerHour, Integer hours) {
		this.date = contractDate;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	// Métodos getters and setters
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue () {
		return valuePerHour * hours;
	}
 	
}