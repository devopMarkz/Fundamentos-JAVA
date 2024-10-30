package entities;

import java.util.ArrayList;
import java.util.List;

import services.BuscadorDeArquivo;
import services.ProcessadorDeArquivo;

public class Empresa {
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	private ProcessadorDeArquivo processadorDeArquivo;
	private BuscadorDeArquivo buscadorDeArquivo;
	private String pathName;
	
	public Empresa(ProcessadorDeArquivo processadorDeArquivo, BuscadorDeArquivo buscadorDeArquivo, String pathName) {
		this.processadorDeArquivo = processadorDeArquivo;
		this.buscadorDeArquivo = buscadorDeArquivo;
		this.pathName = pathName;
		
		this.funcionarios = processadorDeArquivo.carregarFuncionarios(buscadorDeArquivo.getFile(pathName));
	}

	public ProcessadorDeArquivo getProcessadorDeArquivo() {
		return processadorDeArquivo;
	}

	public void setProcessadorDeArquivo(ProcessadorDeArquivo processadorDeArquivo) {
		this.processadorDeArquivo = processadorDeArquivo;
	}

	public BuscadorDeArquivo getBuscadorDeArquivo() {
		return buscadorDeArquivo;
	}

	public void setBuscadorDeArquivo(BuscadorDeArquivo buscadorDeArquivo) {
		this.buscadorDeArquivo = buscadorDeArquivo;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	
	
	// MÉTODOS DA CLASSE
	
	public void ordemAlfabeticaSalarioSuperior(Double valor) {
		funcionarios.stream()
					.filter(f -> f.getSalario() > valor)
					.sorted((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()))
					.forEach(t -> System.out.println(t.getEmail()));
	}
	
	public Double somaSalarioFuncionariosM() {
		
		return funcionarios.stream()
				.filter(f -> f.getNome().startsWith("M"))
				.map(t -> t.getSalario())
				.reduce(0.0, (x, y) -> x + y);
		
	}

}
