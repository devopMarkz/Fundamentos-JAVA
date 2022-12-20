package model.entities;

public class Contact {

	private String name;
	private String phoneNumber;
	
	// Construtores da classe
	
	public Contact() {
	}
	
	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	// Métodos getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// Métodos da classe
	
	@Override
	public String toString() {
		return name + "," + phoneNumber;
	}
}
