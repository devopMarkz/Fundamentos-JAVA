package entities;

public class Product implements Comparable<Product> {
	
	private String name;
	private Double price;
	
	/**
	 * Construtor padrão.
	 */
	public Product() {
	}
	
	/**
	 * Construtor.
	 * @param name Nome do produto.
	 * @param price Preço do produto.
	 */
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

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
	
	@Override
	public String toString() {
		return name + ", R$" + price; 
	}

	@Override
	public int compareTo(Product o) {
		Double valor1 = Double.valueOf(this.price);
		Double valor2 = Double.valueOf(o.price);
		
		// Utiliza o m�todo compareTo() da classe Double, que j� efetua a compara��o dos n�meros
		return valor1.compareTo(valor2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null)? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
