package entities;

import entities.enums.Color;

public abstract class Forma {

	private Color color;
	
	// Construtores da classe
	
	public Forma () {
	}
	
	public Forma(Color color) {
		this.color = color;
	}
	
	// Métodos getters and setters

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	// Métodos da classe
	
	public abstract double area();
	
}
