package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GestorDePedidos {
	
	private List<Produto> lista = new ArrayList<>();

	public List<Produto> getLista() {
		return lista;
	}
	
	public void removeIf(Predicate<Produto> teste) {
		for (Produto produto : lista) {
			if(teste.test(produto)) lista.remove(produto);
		}
	}
	
	public Double calculate(Predicate<Produto> teste) {
		Double soma = 0.0;
		for (Produto produto : lista) {
			if(teste.test(produto)) {
				soma += produto.getPreco();
			}
		}
		return soma;
	}
	
}