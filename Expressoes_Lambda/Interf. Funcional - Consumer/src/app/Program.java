package app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entities.Produto;

public class Program {

	public static void main(String[] args) {
		
		// USO DO CONSUMER<T>, QUE TRATA-SE DE UMA INTERFACE FUNCIONAL QUE RECEBE UMA ENTRADA E EFETUA UMA AÇÃO
		// POSSUI O MÉTODO ABSTRATO accept QUE RECEBE UMA ENTRADA MAS NÃO RETORNA VALOR
		

		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto(4, "TV", 1900.00));
		produtos.add(new Produto(1, "Geladeira", 2900.00));
		produtos.add(new Produto(5, "Cama", 800.00));
		produtos.add(new Produto(2, "Cômoda", 700.00));
		produtos.add(new Produto(3, "Garrafa", 200.00));
		
		Double percent1 = 0.1;
		
		// COM CLASSES ANÔNIMAS:
		
		Consumer<Produto> cons1 = new Consumer<Produto>() {
			@Override
			public void accept(Produto t) {
				t.increasePrice(percent1);  // Conceito de Closure, quando uma lambda utiliza uma variável externa
			}
		};
		
		produtos.forEach(cons1);
		
		produtos.forEach(System.out::println);
		
		System.out.println("\n--------------------------------------------------\n");
		
		// COM EXPRESSÕES LAMBDA DECLARADAS:
		
		Consumer<Produto> cons2 = t -> t.increasePrice(0.5);
		
		produtos.forEach(cons2);
		
		produtos.forEach(System.out::println);

		System.out.println("\n--------------------------------------------------\n");

		// COM EXPRESSÕES LAMBDA INLINE:
		
		produtos.forEach(t -> t.increasePrice(1));

		produtos.forEach(System.out::println);
	}

}
