package composicao;

import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;
import entities.contract.HourContract;
import entities.department.Department;
import entities.level.EmployeeLevel;


public class Main {

	public static void main(String[] args) {
		
		/* Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). 
		   Depois, solicitar do usuário um mês e mostrar qual foi o salário do funcionário nesse mês
		   , incluindo a soma do salário base + salarios dos contratos.*/

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		// Descrição do departamento
		System.out.print("Insira o nome do departamento: ");
		String depart = sc.nextLine();
		
		// Criando objeto deepartamento
		Department department = new Department (depart);
		
		// Coletando dados do funcionário
		System.out.println("Insira os dados do funcionário: ");
		
		System.out.print("Nome: ");
		String name = sc.nextLine();
		
		System.out.print("Nível (junior / mid_level / senior): ");
		String lv = sc.next().toUpperCase();
		EmployeeLevel level = EmployeeLevel.valueOf(lv);
		
		System.out.println("Salário base: ");
		Double baseSalary = sc.nextDouble();
		
		// Criando objeto funcionário
		Funcionario funcionario = new Funcionario(name, level, baseSalary);
		
		// Criação de contratos
		System.out.print("Quantos contratos deseja dar à esse funcionário? ");
		Integer contractNumber = sc.nextInt();
		
		HourContract[] contratos = new HourContract[contractNumber];
		
		for (int i = 0; i < contratos.length; i++) {
			sc.nextLine();
			System.out.println("Insira os dados do contrato #" + (i+1));
			
			System.out.print("Data (DD/MM/YYYY): ");
			String data = sc.nextLine();
			
			System.out.print("Valor por hora: ");
			Double valuePerHour = sc.nextDouble();
			
			System.out.print("Duração (horaas): ");
			Integer hours = sc.nextInt();
			
			contratos[i] = new HourContract(data, valuePerHour, hours);
		}
		
		sc.nextLine();
		
		System.out.print("Insira o mês e o ano para calcular a renda do funcionário (MM/YYYY): ");
		String incomeByDate = sc.nextLine();
		
		System.out.println(funcionario.toString(department, incomeByDate, contratos));
		
		sc.close();

	}

}
