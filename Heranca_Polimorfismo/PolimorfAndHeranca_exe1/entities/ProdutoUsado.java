package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ProdutoUsado extends Produto {
	
	private LocalDate manufactureDate;
	
	// Formatação de data
	private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Construtores da classe
	
	public ProdutoUsado () {
	}
	
	public ProdutoUsado (String name, double price, LocalDate manufactureDate) {
		super (name, price);
		this.manufactureDate = manufactureDate;
	}

	// Métodos getters and setters
	
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	// Métodos da classe
	
	@Override 
	public String priceTag () {
		return super.getName() 
				+ " (used) $ "
				+ super.getPrice()
				+ String.format(" (Manufacture date: %s) ", manufactureDate.format(fmt1));
	}

}
