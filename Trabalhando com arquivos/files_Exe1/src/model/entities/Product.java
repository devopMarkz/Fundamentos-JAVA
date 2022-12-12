package model.entities;

public class Product {
	
	private String name;
	private Double price;
	private Integer quantity;
	
	// Construtores da classe
	
	public Product () {
	}
	
	public Product (String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	// Métodos da classe
	
	public double totalValue () {
		return this.price * this.quantity;
	}
	
	@Override
	public String toString() {
		return this.name + ","
				+ this.price + ","
				+ this.quantity;
	}

}
