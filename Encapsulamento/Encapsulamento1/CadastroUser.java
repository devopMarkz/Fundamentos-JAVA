package exercJAVA;
import java.util.Scanner;
import java.util.Locale;
import contaBancaria.ContaBancaria;

public class CadastroUser {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Qual o número da sua conta bancária? ");
		Integer accountNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Qual o seu nome como titular da conta? ");
		String holdersName = sc.nextLine();
		
		System.out.print("Deseja ralizar um depósito inicial? ");
		String resposta = sc.nextLine();
		
		ContaBancaria cad1;
		
		if (resposta.charAt(0) == 's') {
			System.out.print("Insira o valor do depósito inicial: ");
			Double initialDeposit = sc.nextDouble();
			cad1 = new ContaBancaria (accountNumber, holdersName, initialDeposit);
		}
		else {
			cad1 = new ContaBancaria (accountNumber, holdersName);
		}
		
		System.out.println();
		
		System.out.println("Dados da conta: ");
		System.out.println(cad1.toString());
		
		System.out.println();
		
		System.out.print("Informe o valor de depósito: ");
		Double depositAmount = sc.nextDouble();
		cad1.deposit(depositAmount);
		
		System.out.println("Dados da conta atualizados: ");
		System.out.println(cad1.toString());
		
		System.out.println();
		
		System.out.print("Informe o valor de saque: ");
		Double takeoutValue = sc.nextDouble();
		cad1.cashWithdrawn(takeoutValue);
		
		System.out.println("Dados da conta atualizados: ");
		System.out.println(cad1.toString());
		
			
		sc.close();

	}

}