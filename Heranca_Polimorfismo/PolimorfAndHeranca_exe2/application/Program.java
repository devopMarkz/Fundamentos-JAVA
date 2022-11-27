package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circulo;
import entities.Forma;
import entities.Retangulo;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Lista para armazenar formas e tipo genérico Forma
		List <Forma> listaFormas = new ArrayList<>();
		Forma forma;
		
		System.out.print("Quantas formas irá preencher? ");
		int numFormas = sc.nextInt();
		
		for (int i = 1; i <= numFormas; i++) {
			
			System.out.println("Dados da forma #" + i);
			
			char resposta; // Resposta sobre o tipo da forma
			
			do {
				System.out.print("Retângulo ou circulo (r/c)? ");
				resposta = Character.toLowerCase(sc.next().charAt(0));
			} while (resposta != 'r' && resposta != 'c');
		
			System.out.print("Color (PRETO/AZUL/VERMELHO): ");
			Color color = Color.valueOf(sc.next().toUpperCase());
			
			// Checa se é retângulo ou circulo para instância de objeto
			if (resposta == 'r') {
				System.out.print("Largura: ");
				double largura = sc.nextDouble();
				
				System.out.print("Altura: ");
				double altura = sc.nextDouble();
				
				forma = new Retangulo(color, largura, altura); // Instância de retangulo
			}
			else {
				System.out.print("Raio: ");
				double raio = sc.nextDouble();
				
				forma = new Circulo(color, raio); // Instância de circulo
			}
			
			listaFormas.add(forma); // Adicionando objeto na lista
			
		} // Fim do laço for
		
		System.out.println();
		
		System.out.println("ÁREAS DAS FORMAS: ");
		for (Forma formas : listaFormas) {
			System.out.println(String.format("%.2f", formas.area()));
		}
		
		sc.close();

	}

}
