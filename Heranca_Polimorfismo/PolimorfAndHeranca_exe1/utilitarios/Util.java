package utilitarios;

import java.util.List;

import entities.Produto;

// Classe responsável por armazenar funções utilitárias
public class Util {
	
	// Retorna um texto com a informação de todos os produtods
	public static String productInformation (List <Produto> listaProdutos) {
		
		StringBuilder almost = new StringBuilder(); // Objeto que armazena o texto
		
		for (Produto produto : listaProdutos) almost.append(produto.priceTag() + "\n");
		
		return almost.toString();
	}

}
