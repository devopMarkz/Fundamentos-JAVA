package app;

import java.util.Locale;

import entities.Gerenciador;
import services.ProcessadorTxt;
import services.SearchFile;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String pathName = "C:\\Users\\marcos.andre\\Desktop\\Suprimentos CPL\\arquivos java\\Prog. Funcional e Expressões lambda\\stream_atv\\src\\produtos.txt";

		Gerenciador g = new Gerenciador(new SearchFile(), new ProcessadorTxt(), pathName);
		
		System.out.println(g.precoMedioProdutos());
		
		g.exibirProdutosAbaixoDaMedia();
		
	}

}
