package entities;

public class Employee {
	
	protected String name;
	private Integer hours;
	private Double valuePerHour;
	
	// Construtores da classe
	
	public Employee () {
	}

	public Employee (String name, int hours, double valuePerHour) {
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}
	
	// Métodos getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	
	// Métodos da classe
	
	public double payment () {
		return valuePerHour * hours; // Retorna o salário (pagamento) do funcionário
	}
	
	@Override
	public String toString () {
		return name + " - $ " 
				+ payment();
	}
	
}
