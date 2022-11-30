package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Lista para armazenar os objetos Employee (Funcionário)
		List <Employee> listaFuncionarios = new ArrayList <>();
		
		System.out.print("Quantos funcionários deseja registrar? ");
		int numFuncionarios = sc.nextInt();
		
		for (int i = 0; i < numFuncionarios; i++) {
			System.out.println("Funcionario #" + (i+1) + ": ");
			
			System.out.print("ID: ");
			int id = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			
			listaFuncionarios.add(new Employee(id, nome, salario)); // Add objeto Employee à lista
		}
		
		System.out.print("Insira o ID do funcionário que você deseja conceder um aumento no salário: ");
		int checkId = sc.nextInt();
		
		System.out.print("Informe a porcentagem de aumento que irá conceder: ");
		double porcentAumento = sc.nextDouble();
		
		// Busca o funcionário na lista cujo ID bate com o requerido
		Employee funcionarioAumento = listaFuncionarios.stream().filter(x -> x.getId() == checkId).findFirst().orElse(null);
		
		// Checa se o funcionário existe para poder realizar o aumento em seu salário
		if (funcionarioAumento == null) {
			System.out.println("ID inexistente. Processo abortado.");
		}
		else {
			for (Employee employee : listaFuncionarios) {
				if (employee.getId() == funcionarioAumento.getId()) employee.increaseSalary(porcentAumento);
			}
		}
		
		// LISTA ATUALIZADA DE FUNCIONÁRIOS E SUAS INFORMAÇÕES
		for (Employee employee : listaFuncionarios) {
			System.out.println(employee.toString());
		}		
		sc.close();

	}

} // NOTA: Poderia utilizar funções para checagem de ID, mas para uma melhor visualização, deixei dentro da função executável
