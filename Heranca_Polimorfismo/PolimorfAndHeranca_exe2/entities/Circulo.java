package entities;

import entities.enums.Color;

public class Circulo extends Forma {
	
	private Double raio;
	
	// Construtores da classe

	public Circulo() {
	}
	
	public Circulo (Color color, double raio) {
		super (color);
		this.raio = raio;
	}
	
	// Métodos getters and setters

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}
	
	// Métodos da classe
	
	@Override
	public double area () {
		return 2*Math.PI*this.raio;
	}

}
