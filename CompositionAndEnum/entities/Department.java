package entities;

public class Department {

	private String name;
	
	// Construtores da classe
	public Department () {}
	
	public Department(String departmentName) {
		this.name = departmentName;
	}

	// Métodos getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
