package entities;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import entities.contract.HourContract;
import entities.level.EmployeeLevel;

import entities.department.Department;

public class Funcionario {
	
	private String name;
	private EmployeeLevel level;
	private Double baseSalary;
	
	// Construtores da classe
	public Funcionario () {}
	
	public Funcionario (String name, EmployeeLevel level, Double baseSalary) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}
	
	// Métodos getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeLevel getLevel() {
		return level;
	}

	public void setLevel(EmployeeLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	// Métodos da classe
	public Double renda (String incomeByDate, HourContract[] contratos) {
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/yyyy");
		YearMonth monthYear = YearMonth.parse(incomeByDate, fmt2);
		
		Double sum = 0.0;
		
		for (int i = 0; i < contratos.length; i++) {
			if (YearMonth.from(contratos[i].getDate()) == monthYear) {
				sum = sum + (contratos[i].getHours()*contratos[i].getValuePerHour());
			}
		}
		
		return sum;
		
	}
	
	public String toString (Department department, String incomeByDate, HourContract[] contratos) {
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/yyyy");
		YearMonth monthYear = YearMonth.parse(incomeByDate, fmt2);
		
		Double sum = 0.0;
		
		for (int i = 0; i < contratos.length; i++) {
			if (YearMonth.from(contratos[i].getDate()).equals(monthYear)) {
				sum = sum + (contratos[i].getHours()*contratos[i].getValuePerHour());
			}
		}
		return String.format("Name: %s%nDepartment: %s%nIncome for %s: %.2f", this.name, department.toString(), incomeByDate,
				sum);
	}

}
