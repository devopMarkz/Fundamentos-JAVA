package entities;

public class Vehicle {
	
	private String vehicle;
	private String licensePlate;
	
	// Construtores da classe
	
	public Vehicle() {
	}

	public Vehicle(String carModel, String licensePlate) {
		this.vehicle = carModel;
		this.licensePlate = licensePlate;
	}
	
	// Métodos getters e setters

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

}
