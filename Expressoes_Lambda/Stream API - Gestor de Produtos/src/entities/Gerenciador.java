package entities;

import java.util.ArrayList;
import java.util.List;

import services.ProcessadorDeArquivo;
import services.SearchFileService;

public class Gerenciador {
	
	private SearchFileService buscadorDeArquivo;
	private ProcessadorDeArquivo processadorDeArquivo;
	private List<Produto> produtos = new ArrayList<>();
	private String pathName;
	
	// CONSTRUTORES
	
	public Gerenciador(SearchFileService buscadorDeArquivo, ProcessadorDeArquivo processadorDeArquivo, String pathName) {
		this.buscadorDeArquivo = buscadorDeArquivo;
		this.processadorDeArquivo = processadorDeArquivo;
		this.pathName = pathName;
		this.produtos = processadorDeArquivo.carregarProdutosDeArquivo(buscadorDeArquivo.getFile(pathName));
	}
	
	// GETTERS E SETTERS
	
	public SearchFileService getBuscadorDeArquivo() {
		return buscadorDeArquivo;
	}
	
	public void setBuscadorDeArquivo(SearchFileService buscadorDeArquivo) {
		this.buscadorDeArquivo = buscadorDeArquivo;
	}
	
	public ProcessadorDeArquivo getProcessadorDeArquivo() {
		return processadorDeArquivo;
	}

	public void setProcessadorDeArquivo(ProcessadorDeArquivo processadorDeArquivo) {
		this.processadorDeArquivo = processadorDeArquivo;
	}

	public void setLeitorDeArquivo(SearchFileService buscadorDeArquivo) {
		this.buscadorDeArquivo = buscadorDeArquivo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	
	// MÉTODOS DA CLASSE

	public Double precoMedioProdutos() {
		
		return produtos.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (x,y) -> x + y) / produtos.size();
		
	}
	
	public void salvarProdutos(Produto produto) {
		processadorDeArquivo.salvarProdutoEmArquivo(buscadorDeArquivo.getFile(pathName), produto);
	}
	
	public void exibirProdutosAbaixoDaMedia() {
		produtos.stream()
		.sorted((o1, o2) -> -o1.getNome().compareTo(o2.getNome()))
		.filter(p -> p.getPreco() < precoMedioProdutos())
		.forEach(System.out::println);
	}

}
