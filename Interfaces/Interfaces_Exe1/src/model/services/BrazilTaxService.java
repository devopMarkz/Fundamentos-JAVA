package model.services;

public class BrazilTaxService implements TaxService {

	@Override
	public Double getTax(double basicPayment) {
		double tax = (basicPayment <= 100.0)? basicPayment * 0.2 : basicPayment * 0.15;
		return tax;
	}

}
