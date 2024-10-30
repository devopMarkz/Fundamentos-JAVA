package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class LeitorDeArquivoTxt implements ProcessadorDeArquivo{

	@Override
	public List<Funcionario> carregarFuncionarios(File file) {

		List<Funcionario> funcionarios = new ArrayList<>();
		
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))){
			while (sc.hasNextLine()) {
				String[] coluna = sc.nextLine().split(",");
				
				String nome = coluna[0];
				String email = coluna[1];
				Double salario = Double.parseDouble(coluna[2]);
				
				funcionarios.add(new Funcionario(nome, email, salario));
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return funcionarios;
		
	}
	
	
	

}
