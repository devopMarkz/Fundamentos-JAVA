package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService paymentService;

	// Construtores da classe
	
	public ContractService() {
	}
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	// Métodos getters and setters

	public OnlinePaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	// Métodos da classe
	
	public void processContract(Contract contract, int months) { // Gera as prestações do contrato
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double amount = contract.getTotalValue() / months;
			
			amount = paymentService.interest(amount, i);
			amount = paymentService.paymentFee(amount);
			
			Installment installment = new Installment(dueDate, amount);
			contract.getInstallments().add(installment);
		}
	}

}
