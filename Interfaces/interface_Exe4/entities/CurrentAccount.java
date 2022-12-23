package entities;

import services.TaxService;

public class CurrentAccount extends BankAccount {
	
	private TaxService tax;
	
	// Construtores da classe
	
	public CurrentAccount(){
		super();
	}
	
	public CurrentAccount(Double balance, TaxService tax) {
		super(balance);
		this.tax = tax;
	}
	
	// Métodos getters e setters

	public TaxService getTax() {
		return tax;
	}

	public void setTax(TaxService tax) {
		this.tax = tax;
	}
	
	// Métodos da classe

	@Override
	public double calculateBalance() {
		if (super.getBalance() - tax.getTax(super.getBalance()) < 0.0) throw new IllegalArgumentException();
		return super.getBalance() - tax.getTax(super.getBalance());
	}
	
}
