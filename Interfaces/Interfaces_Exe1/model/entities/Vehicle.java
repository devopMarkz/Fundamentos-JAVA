package model.entities;

public class Vehicle {
	
	private String name;
	
	// Construtores da classe
	
	public Vehicle() {
	}
	
	public Vehicle(String name) {
		this.name = name;
	}
	
	// Métodos getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Métodos da classe
	
	@Override
	public String toString () {
		return name;
	}

}
