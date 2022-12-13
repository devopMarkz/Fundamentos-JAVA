package entities;

public class Contact {
	
	private String name;
	private Integer phoneNumber;
	
	// Construtores da classe
	
	public Contact () {
	}
	
	public Contact(String name, Integer phoneNumber) {
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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// Métodos da classe 
	
	@Override
	public String toString () {
		return name 
			   + "," + phoneNumber;
	}

}
