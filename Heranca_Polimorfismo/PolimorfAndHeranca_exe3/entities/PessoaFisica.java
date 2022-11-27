package entities;

public final class PessoaFisica extends Contribuinte {

	private Double gastosComSaude;
	
	// Construtores da classe 
	
	public PessoaFisica () {
	}
	
	public PessoaFisica (String nome, double rendaAnual, double gastosComSaude) {
		super (nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}
	
	public PessoaFisica (String nome, double rendaAnual) {
		super (nome, rendaAnual);
	}
	
	// Métodos getters and setters

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}
	
	// Métodos da classe
	
	@Override 
	public double imposto () {
		double imposto = 0;
		
		if (super.getRendaAnual() < 20000) imposto = super.getRendaAnual() * 0.15;
		else if (super.getRendaAnual() > 20000) imposto = super.getRendaAnual() * 0.25;
		
		if (this.gastosComSaude > 0) imposto = imposto - (this.gastosComSaude * 0.5); 
		
		if (imposto < 0) return 0.0; // Caso o imposto seja negativo, não paga imposto
		
		return imposto;
	}
	
}
