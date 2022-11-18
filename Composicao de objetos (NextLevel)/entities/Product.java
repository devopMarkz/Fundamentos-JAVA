package entities;

// PRODUTO
public class Product {
	
	private String name;
	private Double price;
	
	// Construtores da classe
	public Product () {}
	
	public Product (String productName, double productPrice) {
		name = productName;
		price = productPrice;
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
	public String toString () {
		return name +
				", $" +
				String.format("%.2f", price);
	}

}
