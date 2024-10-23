package services;

import java.io.File;
import java.util.List;

import entities.Funcionario;

public interface ProcessadorDeArquivo {
	
	List<Funcionario> carregarFuncionarios(File file);

}
