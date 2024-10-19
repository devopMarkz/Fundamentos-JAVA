package app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Produto;

public class Program {

	public static void main(String[] args) {
		
		// USO DO FUNCTION<T>, QUE TRATA-SE DE UMA INTERFACE FUNCIONAL QUE RECEBE UM VALOR T E RETORNA UM VALOR R
		// POSSUI O MÉTODO ABSTRATO apply QUE RECEBE UMA ENTRADA DE UM TIPO E A RETORNA DE OUTRO TIPO - TRANSFORMA DADOS
		

		List<Produto> produtos = new ArrayList<>();
		
		produtos.add(new Produto(4, "TV", 1900.00));
		produtos.add(new Produto(1, "Geladeira", 2900.00));
		produtos.add(new Produto(5, "Cama", 800.00));
		produtos.add(new Produto(2, "Cômoda", 700.00));
		produtos.add(new Produto(3, "Garrafa", 200.00));

		
		// COM CLASSES ANÔNIMAS:
		
		Function<Produto, String> funct = new Function<Produto, String>() {
			@Override
			public String apply(Produto t) {
				return t.getNome();
			}
		};
		
		List<String> nomesDosProdutos1 = produtos.stream().map(funct).collect(Collectors.toList());
		
		nomesDosProdutos1.forEach(System.out::println);
		
		System.out.println("\n--------------------------------------------------\n");
		
		// COM EXPRESSÕES LAMBDA DECLARADAS:
		
		Function<Produto, String> funct1 = t -> t.getNome().toUpperCase();
		
		List<String> nomesDosProdutos2 = produtos.stream().map(funct1).collect(Collectors.toList());
		
		nomesDosProdutos2.forEach(System.out::println);

		System.out.println("\n--------------------------------------------------\n");

		// COM EXPRESSÕES LAMBDA INLINE:
		
		List<String> nomesDosProdutos3 = produtos.stream().map(t -> t.getNome().toLowerCase()).collect(Collectors.toList());
		
		nomesDosProdutos3.forEach(System.out::println);
		
	}

}
