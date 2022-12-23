package entities;

public abstract class BankAccount {
	
	protected Double balance;

	// Construtores da classe
	
	public BankAccount() {
	}

	public BankAccount(Double balance) {
		this.balance = balance;
	}
	
	// Métodos getters e setters

	public Double getBalance() {
		return balance;
	}
	
	// Métodos da classe
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}
	
	public void withdraw(double withdraw) {
		this.balance -= withdraw;
	}
	
	public void transfer(double transfer) {
		this.balance -= transfer;
	}
	
	public abstract double calculateBalance();
	
}
