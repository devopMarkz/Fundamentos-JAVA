package services;

public class CurrentAccountTaxService implements TaxService {

	@Override
	public double getTax(double balance) {
		return balance * 0.10;
	}

}
