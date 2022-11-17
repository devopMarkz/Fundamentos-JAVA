package entities.department;

public class Department {
	
	private String department;

	// Construtores da classe
	public Department () {}
	
	public Department (String department) {
		this.department = department;
	}
	
	// Métodos getters and setters
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return department;
	}
	
	

}
