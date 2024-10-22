package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Produto;

public class ProcessadorTxt implements ProcessadorDeArquivo {

	@Override
	public List<Produto> carregarProdutosDeArquivo(File file) {
		
		List<Produto> produtos = new ArrayList<>();

		try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))){
			
			while (sc.hasNextLine()) {
				String[] coluna = sc.nextLine().split(",");
				produtos.add(new Produto(coluna[0], Double.parseDouble(coluna[1])));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}

	@Override
	public void salvarProdutoEmArquivo(File file, Produto produto) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			
			bw.write(produto.descricaoDoProduto());
			bw.newLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
