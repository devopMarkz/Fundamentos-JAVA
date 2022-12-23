package application;

import java.util.Locale;
import java.util.Scanner;

import entities.CurrentAccount;
import entities.InvestmentAccount;
import services.CurrentAccountTaxService;
import services.InvestmentAccountIncomeService;

public class Program3 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CONTA CORRENTE: ");
		System.out.print("Deposite uma quantia: ");
		double deposit = sc.nextDouble();
		
		CurrentAccount cr = new CurrentAccount(deposit, new CurrentAccountTaxService());
		
		System.out.println("Saldo: R$" + cr.getBalance());
		
		System.out.print("Saque uma quantia: ");
		double withdraw = sc.nextDouble();
		cr.withdraw(withdraw);
		
		System.out.println("Saldo: R$" + cr.getBalance());
		
		System.out.print("Transfira uma quantia: ");
		double transfer = sc.nextDouble();
		cr.transfer(transfer);
		
		System.out.println("Saldo: R$" + cr.getBalance());
		
		System.out.println("Saldo final: R$" + cr.calculateBalance());
		
		System.out.println("---------------------------------------------------------");
		
		System.out.println("CONTA DE INVESTIMENTO: ");
		System.out.print("Deposite uma quantia: ");
		deposit = sc.nextDouble();
		
		InvestmentAccount ia = new InvestmentAccount(deposit, new InvestmentAccountIncomeService());
		
		System.out.println("Saldo: R$" + ia.getBalance());
		
		System.out.print("Saque uma quantia: ");
		withdraw = sc.nextDouble();
		ia.withdraw(withdraw);
		
		System.out.println("Saldo: R$" + ia.getBalance());
		
		System.out.print("Transfira uma quantia: ");
		transfer = sc.nextDouble();
		ia.transfer(transfer);
		
		System.out.println("Saldo: R$" + ia.getBalance());
		
		System.out.println("Saldo final: R$" + ia.calculateBalance());
		
		sc.close();
		
	}

}
