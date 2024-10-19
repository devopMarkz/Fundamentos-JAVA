package app;

import entities.GestorDePedidos;
import entities.Produto;

public class Program {

	public static void main(String[] args) {

		GestorDePedidos g = new GestorDePedidos();
		g.getLista().add(new Produto(4, "TV", 1900.00));
		g.getLista().add(new Produto(1, "Geladeira", 2900.00));
		g.getLista().add(new Produto(5, "Cama", 800.00));
		g.getLista().add(new Produto(2, "Cômoda", 700.00));
		g.getLista().add(new Produto(3, "Luminária", 200.00));
		
		Produto p1 = new Produto(2, "Cômoda", 700.00);
		
		System.out.println(g.calculate(t -> t.getNome().startsWith("C")));
		
		g.removeIf(x -> x.equals(p1));
		
		g.getLista().sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
		
		g.getLista().forEach(System.out::println);

	}

}
	