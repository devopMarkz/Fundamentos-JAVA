package entities;

// Herda os atributos e métodos de Employee
public final class OutsourcedEmployee extends Employee {
	
	private Double aditionalCharge;
	
	// Construtores da classe
	
	public OutsourcedEmployee () {
	}
	
	public OutsourcedEmployee (String name, int hours, double valuePerHour, double aditionalCharge) {
		super (name, hours, valuePerHour);
		this.aditionalCharge = aditionalCharge;
	}
	
	// Métodos getters and setters

	public Double getAditionalCharge() {
		return aditionalCharge;
	}

	public void setAditionalCharge(Double aditionalCharge) {
		this.aditionalCharge = aditionalCharge;
	}
	
	// Métodos da classe
	
	@Override
	public final double payment () {
		return super.payment() 
				+ (this.aditionalCharge * 110 / 100);
	}
	
	@Override
	public final String toString () {
		return super.name + ", "
				+ this.payment();
	}

}
