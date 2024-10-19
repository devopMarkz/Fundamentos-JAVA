package app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Produto;

public class Program {

	public static void main(String[] args) {
		
		// USO DO PREDICATE<T>, QUE TRATA-SE DE UMA INTERFACE FUNCIONAL QUE AVALIA SE UMA CONDIÇÃO É VERDADEIRA OU FALSA
		// POSSUI O MÉTODO ABSTRATO Test QUE RECEBE UMA ENTRADA E RETORNA UM BOOLEANO
		

		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto(4, "TV", 1900.00));
		produtos.add(new Produto(1, "Geladeira", 2900.00));
		produtos.add(new Produto(5, "Cama", 800.00));
		produtos.add(new Produto(2, "Cômoda", 700.00));
		produtos.add(new Produto(3, "Garrafa", 200.00));
		
		// COM CLASSES ANÔNIMAS:
		
		Predicate<Produto> pred1 = new Predicate<Produto>() {	
			@Override
			public boolean test(Produto t) {
				return t.getNome().startsWith("C");
			}
		};
		
		produtos.removeIf(pred1);
		
		produtos.forEach(System.out::println);
		
		System.out.println("\n--------------------------------------------------\n");
		
		// COM EXPRESSÕES LAMBDA DECLARADAS:
		
		Predicate<Produto> pred2 = t -> t.getNome().startsWith("T");
		
		produtos.removeIf(pred2);
		
		produtos.forEach(System.out::println);

		System.out.println("\n--------------------------------------------------\n");

		// COM EXPRESSÕES LAMBDA INLINE:
		
		produtos.removeIf(t -> t.getNome().startsWith("G"));
		
		produtos.forEach(System.out::println);

	}

}
