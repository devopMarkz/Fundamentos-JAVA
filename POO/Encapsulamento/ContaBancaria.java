package contaBancaria;

public class ContaBancaria {

	private Integer accountNumber;
	private String holdersName;
	private Double accountBalance;
	
	// Construtores da classe
	
	public ContaBancaria (Integer accountNumber, String holdersName, Double initialDeposit) {
		this.accountNumber = accountNumber;
		this.holdersName = holdersName;
		deposit(initialDeposit);
	}
	
	public ContaBancaria (Integer accountNumber, String holdersName) {
		this.accountNumber = accountNumber;
		this.holdersName = holdersName;
	}
	
	// Métodos getters and setters
	
	public Integer getAccountNumber () {
		return this.accountNumber;
	}
	
	public String getHoldersName () {
		return this.holdersName;
	}
	
	public void setHoldersName (String holdersName) {
		this.holdersName = holdersName;
	}
	
	public Double getAccountBalance () {
		return this.accountBalance;
	}
	
	// Métodos da classe
	
	public String toString () {
		return String.format("Conta %d, Titular: %s, Saldo Bancário: R$%.2f", accountNumber, holdersName, accountBalance);
	}
	
	public void deposit (Double depositAmount) {
		this.accountBalance += depositAmount;
	}
	
	public void cashWithdrawn (Double takeoutValue) {
		this.accountBalance -= (takeoutValue + 5);
	}
	
	
}
