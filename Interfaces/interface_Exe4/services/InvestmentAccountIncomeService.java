package services;

public class InvestmentAccountIncomeService implements IncomeService {

	@Override
	public double getIncome(double balance) {
		return balance * 0.05;
	}

}
