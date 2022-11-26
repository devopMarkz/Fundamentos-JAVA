package entities;

public final class ProdutoImportado extends Produto {
	
	private Double customsFee; // Taxa alfandegária
	
	// Construtores da classe
	
	public ProdutoImportado () {
	}
	
	public ProdutoImportado (String name, double price, double customsFee) {
		super (name, price);
		this.customsFee = customsFee;
	}
	
	// Métodos getters and setters

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	// Métodos da classe
	
	@Override
	public String priceTag () {
		return super.priceTag() 
				+ String.format(" (Customs fee: $ %.2f)", totalPrice());
	}
	
	public Double totalPrice () {
		return super.getPrice() + this.customsFee;
	}

}
