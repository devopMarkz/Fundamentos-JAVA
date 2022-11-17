package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {

	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;
	
	// Construtores da classe
	public HourContract () {}
	
	public HourContract(String data, Double valuePerHour, Integer hours) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(data, fmt1);
		this.date = date;
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
	
}
