package entities;

import entities.enums.Color;

public class Retangulo extends Forma {
	
	private Double largura;
	private Double altura;
	
	// Construtores da classe
	
	public Retangulo () {
	}
	
	public Retangulo (Color color, double largura, double altura) {
		super (color);
		this.largura = largura;
		this.altura = altura;
	}
	
	// Métodos getters and setters
	
	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	// Métodos da classe
	
	@Override 
	public double area () {
		return largura * altura;
	}


}
