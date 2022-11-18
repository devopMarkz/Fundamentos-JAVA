package entities;

// ITEM DO PEDIDO
public class OrderItem {
	
	// Atributos da classe
	private Integer quantity;
	private Double price;
	
	// Atributos de associação
	private Product product; // Os itens do pedido contém o objeto produto
	
	// Construtores da classe
	public OrderItem () {}
	
	// O preço do objeto item (OrderItem) vem do preço fixo do objeto produto (Product) que está sendo solicitado
	// Logo, intanciamos o objeto produto dentro do objeto item, nos argumentos de seu construtor
	public OrderItem (int productQuantity, Product product) {
		quantity = productQuantity;
		price = product.getPrice(); // O preço do item da lista vem do preço fixo do produto
		this.product = product;
	}
	
	// Métodos getters and setters
	public Product getProduct () {
		return product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Métodos da classe
	public Double subTotal () {
		return quantity * price; 
	}
	
	public String toString () {
		StringBuilder almost = new StringBuilder ();
		almost.append(
				product.getName()
				+ ", R$" 
				+ String.format("%.2f", product.getPrice()) 
				+ ", " 
				+ quantity
				+ " unidades, Subtotal: R$" 
				+ String.format("%.2f", subTotal()));
		return almost.toString();
	}

}
