package entities;

import services.IncomeService;

public class InvestmentAccount extends BankAccount {
	
	private IncomeService income;
	
	// Construtores da classe
	
	public InvestmentAccount() {
		super();
	}

	public InvestmentAccount(Double balance, IncomeService income) {
		super(balance);
		this.income = income;
	}
	
	// Métodos getters e setters

	public IncomeService getIncome() {
		return income;
	}

	public void setIncome(IncomeService income) {
		this.income = income;
	}
	
	// Métodos da classe

	@Override
	public double calculateBalance() {
		if (super.getBalance() + income.getIncome(super.getBalance()) < 0) throw new IllegalArgumentException();
		return super.getBalance() + income.getIncome(super.getBalance());
	}

}
