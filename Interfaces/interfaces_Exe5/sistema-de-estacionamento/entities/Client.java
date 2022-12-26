package entities;

public class Client {
	
	private String name;
	private String cpf;
	
	private Vehicle vehicle;
	
	// Construtores da classe
	
	public Client() {
	}

	public Client(String name, String cpf, Vehicle vehicle) {
		if (cpf.length() > 11) throw new IllegalArgumentException();
		this.name = name;
		this.cpf = cpf;
		this.vehicle = vehicle;
	}
	
	// Getters e setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
