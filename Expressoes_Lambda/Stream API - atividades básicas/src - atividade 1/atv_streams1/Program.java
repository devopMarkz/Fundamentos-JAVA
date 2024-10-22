package atv_streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
	
	static List<String> itens = Arrays.asList("Computador", "Papel", "Caneta", "Quadro", "Borracha", "Cortina", "Gaveta");

	public static void main(String[] args) {
		
		executar1();
		
		System.out.println("\n------------------------------------\n");
		
		executar2();
		
		executar3();
		
	}
	
	private static void executar1() {
		// 1. Ordenar a lista
		// 2. Manter só os 3 primeiros elementos
		// 3. Mostrar os resultados na tela
		
		itens.stream()
		.sorted()
		.limit(3)
		.forEach(System.out::println);
	}
	
	private static void executar2() {
		// 1. Filtrar só os elementos com a letra 'C'
		// 2. Montar uma nova lista com estes elementos
		
		List<String> itensComALetraC = itens.stream()
				.filter(item -> item.contains("C"))
				.collect(Collectors.toList());
		
		itensComALetraC.forEach(System.out::println);
	}
	
	private static void executar3() {
		// 1. Somar a quantidade de caracteres de todos os elementos
		// 2. Retornar a soma
		
		int sum = itens.stream()
		.map(x -> x.length())
		.reduce(0, (x, y) -> x + y).intValue();
		
		System.out.println(sum);
	}

}
