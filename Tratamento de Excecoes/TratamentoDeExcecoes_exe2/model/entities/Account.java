package model.entities;

import model.exceptions.AccountWithdrawException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	// Construtores da classe
	
	public Account () {
	}
	
	public Account(int number, String holder, double initialBalance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = initialBalance;
		this.withdrawLimit = withdrawLimit;
	}
	
	// Métodos getters and setters
	
	public Integer getNumber() {
		return this.number;
	}
	
	public Double getBalance () {
		return this.balance;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	// Métodos da classe
	
	public void deposit (double amount) {
		this.balance += amount;
	}
	
	public void withdraw (double amount) throws AccountWithdrawException {
		if (amount > this.balance) throw new AccountWithdrawException("the withdrawal amount cannot be greater than the account balance");
		if (amount > this.withdrawLimit) throw new AccountWithdrawException("The withdrawal amount is greater than the withdrawal limit");
		this.balance -= amount;
	}
	
}
