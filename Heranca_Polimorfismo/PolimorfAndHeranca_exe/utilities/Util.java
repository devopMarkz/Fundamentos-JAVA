package utilities;

import java.util.List;

import entities.Employee;

// Pacote destinado à funções utilitárias do código
public class Util {
	
	public static String employeeInformation (List <Employee> listaFuncionarios) {
		
		// Objeto responsável por armazenar as informações dos funcionários da lista
		StringBuilder employeeInfos = new StringBuilder();
		
		for (Employee employee : listaFuncionarios) {
			employeeInfos.append(employee.toString() + "\n");
		}
		
		return employeeInfos.toString();
	}
	
}
