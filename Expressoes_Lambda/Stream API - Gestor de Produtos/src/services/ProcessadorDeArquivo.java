package services;

import java.io.File;
import java.util.List;

import entities.Produto;

public interface ProcessadorDeArquivo {
	
	List<Produto> carregarProdutosDeArquivo(File file);
	
	void salvarProdutoEmArquivo(File file, Produto produto);

}
