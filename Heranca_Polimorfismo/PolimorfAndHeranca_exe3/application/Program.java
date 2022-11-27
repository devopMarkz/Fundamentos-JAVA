package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Lista de contribuintes
		List <Contribuinte> listaContribuintes = new ArrayList <>();
		
		System.out.print("Insira o número de contribuintes: ");
		int numContribuintes = sc.nextInt();
		
		for (int i = 1; i <= numContribuintes; i++) {
			
			System.out.println("Dados do contribuinte #" + i);
			
			char resposta; // Variável destinada a respostas no código
			
			do {
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			resposta = Character.toLowerCase(sc.next().charAt(0));
			} while (resposta != 'f' && resposta != 'j');
			
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Renda anual: R$");
			double rendaAnual = sc.nextDouble();
			
			if (resposta == 'f') {
				System.out.print("Você teve gastos com saúde (sim/não)? ");
				resposta = sc.next().charAt(0);
				
				if (resposta == 's') {
					System.out.print("Gastos com saude: R$");
					double gastosComSaude = sc.nextDouble();
					
					listaContribuintes.add(new PessoaFisica(nome, rendaAnual, gastosComSaude)); // Add PessoaFísica à lista (Sobrecarga)
				}
				else {
					listaContribuintes.add(new PessoaFisica(nome, rendaAnual)); // Add PessoaFísica à lista (Sobrecarga)
				}
			}
			else {
				System.out.print("Número de funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				
				listaContribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios)); // Add PessoaJurídica à lista
			}
			
		} // Fim do laço for
		
		System.out.println();
		
		System.out.println("IMPOSTOS PAGOS: ");
		for (Contribuinte contribuinte : listaContribuintes) {
			System.out.println(contribuinte.toString());
		}
		
		System.out.println();
		
		// Realiza a soma de todos os impostos
		double sum = 0;
		for (Contribuinte contribuinte : listaContribuintes) {
			sum += contribuinte.imposto();
		}

		System.out.print("IMPOSTOS TOTAIS: " + String.format("$ %.2f", sum));
		
		sc.close();
		
	}

}
