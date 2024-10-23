package app;

import entities.Empresa;
import services.BuscadorDeTxt;
import services.LeitorDeArquivoTxt;
import services.ScannerService;

public class Program {

	public static void main(String[] args) {
		
		String pathName = "C:\\Users\\marcos.andre\\Desktop\\Suprimentos CPL\\arquivos java\\Prog. Funcional e Expressões lambda\\stream_atv2\\src\\funcionarios.txt";

		Empresa empresa = new Empresa(new LeitorDeArquivoTxt(), new BuscadorDeTxt(), pathName);
		
		Double valor = ScannerService.sc.nextDouble();
		
		empresa.ordemAlfabeticaSalarioSuperior(valor);
		
		System.out.println(empresa.somaSalarioFuncionariosM());
		
	}

}
