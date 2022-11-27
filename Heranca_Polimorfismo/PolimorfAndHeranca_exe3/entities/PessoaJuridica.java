package entities;

public final class PessoaJuridica extends Contribuinte {
	
	private Integer numeroDeFuncionarios;
	
	// Construtores da classe
	
	public PessoaJuridica () {
	}
	
	public PessoaJuridica (String nome, double rendaAnual, int numeroDeFuncionarios) {
		super (nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	// Métodos getters and setters

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	// Métodos da classe
	
	@Override 
	public double imposto () {
		double imposto = (this.numeroDeFuncionarios > 10)? super.getRendaAnual() * 0.14 : super.getRendaAnual() * 0.16;
		return imposto;
	}

}
