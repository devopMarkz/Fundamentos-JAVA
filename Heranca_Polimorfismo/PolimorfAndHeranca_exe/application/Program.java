package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;
import utilities.Util;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Insira o número de funcionários: ");
		int numberFuncionarios = sc.nextInt();
		
		// Lista para armazenar os Funcionarios
		List <Employee> listaFuncionarios = new ArrayList<> (); 
		
		for (int i = 1; i <= numberFuncionarios; i++) {
			
			// Declaração do tipo Funcionario e variável resposta
			Employee funcionario;
			String resposta;
			
			// Coletando os dados do funcionário
			System.out.println("Dados do funcionario #" + i);
			
			// Previne inconsistências
			do {
				System.out.print("Terceirizado (sim/não)? ");
				resposta = sc.next().toLowerCase();
			} while (resposta.charAt(0) != 'n' && resposta.charAt(0) != 's');
			
			sc.nextLine();
		
			System.out.print("Nome: ");
			String name = sc.nextLine();
					
			System.out.print("Horas trabalhadas: ");
			int hours = sc.nextInt();
					
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
					
			// Decide se o tipo genérico Employee irá ou não receber um objeto específico e comportamentos de outro tipo
			if (resposta.charAt(0) == 's') {
				System.out.print("Despesa adicional: ");
				double additionalCharge = sc.nextDouble();
				funcionario = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
			}
			else {
				funcionario = new Employee(name, hours, valuePerHour);
			}
			
			listaFuncionarios.add(funcionario); // Registrando funcionarios numa lista
					
		} // Final do laço for
		
		
		System.out.println("PAYMENTS: ");
		
		// Método responsável por retornar as informações dos funcionarios na lista
		System.out.println(Util.employeeInformation(listaFuncionarios)); 
			
		sc.close();			
			
	}

}