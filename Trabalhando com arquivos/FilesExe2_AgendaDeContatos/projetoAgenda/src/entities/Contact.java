package entities;

public class Contact {
	
	private String name;
	private Long phoneNumber;
	
	// Construtores da classe
	
	public Contact () {
	}
	
	public Contact(String name, long phoneNumber) {
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// Métodos da classe 
	
	@Override
	public String toString () {
		return name 
			   + ","
			   + phoneNumber;
	}

}
