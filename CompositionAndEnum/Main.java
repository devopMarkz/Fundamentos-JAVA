package application;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) {
		
		/* Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). 
		   Depois, solicitar do usuário um mês e mostrar qual foi o salário do funcionário nesse mês
		   , incluindo a soma do salário base + salarios dos contratos.*/

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/yyyy");
		
		// Criando objeto department
		System.out.print("Insira o nome do departamento: ");
		String departmentName = sc.nextLine();
		
		// Inserindo dados no objeto worker
		System.out.printf("Insira os dados do trabalhador: %nName: ");
		String name = sc.nextLine();
		
		System.out.print("Level (JUNIOR/MID_LEVEL/SENIOR): ");
		String workerLevel = sc.next().toUpperCase();
		
		System.out.print("Salário base: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("Quantos contratos deseja dar à esse trabalhador");
		int contracts = sc.nextInt();
		
		for (int i = 0; i < contracts; i++) {
			System.out.println("Insira os dados do contrato #" + (i + 1));
			
			System.out.print("Data (DD/MM/YYYY): ");
			LocalDate contractDate = LocalDate.parse(sc.next(), fmt1);
			
			System.out.print("Valor por hora: ");
			Double valuePerHour = sc.nextDouble();
			
			System.out.print("Duração: ");
			Integer hours = sc.nextInt();
			
			// Gerando objeto contract e salvando dentro da lista de contratos do objeto worker
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.print("Insira o mês e o ano para calcular a renda do trabalhador (MM/YYYY): ");
		YearMonth yearMonth = YearMonth.parse(sc.next(), fmt2);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Renda de " + yearMonth.format(fmt2) + ": " + worker.income(yearMonth));
		 
		
		sc.close();

	}

}
