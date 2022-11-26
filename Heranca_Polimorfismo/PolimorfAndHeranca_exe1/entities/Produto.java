package entities;

public class Produto {
	
	private String name;
	private Double price;
	
	// Construtores da classe
	public Produto () {
	}
	
	public Produto (String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	// Métodos getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Métodos da classe
	
	public String priceTag () {
		return name + " $ " + price;
	}

}
