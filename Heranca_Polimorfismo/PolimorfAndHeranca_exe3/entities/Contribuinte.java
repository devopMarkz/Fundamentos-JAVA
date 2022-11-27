package entities;

public abstract class Contribuinte {
	
	private String nome;
	private Double rendaAnual;
	
	// Construtores da classe
	
	public Contribuinte () {
	}
	
	public Contribuinte (String nome, double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}
	
	// Métodos getters and setters

	public String getName() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	// Métodos da classe
	
	public abstract double imposto ();
	
	public String toString () {
		return nome + " - " + String.format("$ %.2f", imposto());
	}

}
