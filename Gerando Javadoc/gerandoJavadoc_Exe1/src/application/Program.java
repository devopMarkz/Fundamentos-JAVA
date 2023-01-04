package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Aluno;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
		Aluno aluno = new Aluno(nome);
		
		System.out.println("Quantas notas deseja inserir? ");
		int quantNotas = sc.nextInt();
		
		double[] vect = new double[quantNotas];
		
		System.out.println("Digite suas notas: ");
		
		for (int i = 0; i < vect.length; i++) {
			double nota = sc.nextDouble();
			vect[i] = nota;
		}
		
		double sum = 0;
		for (int i = 0; i < vect.length; i++) {
			sum += vect[i];
		}
		
		aluno.mediaAluno(sum, quantNotas);
		
		sc.close();

	}

}
