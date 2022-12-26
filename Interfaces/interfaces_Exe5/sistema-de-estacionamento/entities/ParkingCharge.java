package entities;

import java.time.format.DateTimeFormatter;

public class ParkingCharge {
	
	private Client client;
	private PaymentTicket paymentTicket;
	
	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	// Construtores da classe
	
	public ParkingCharge(){
	}

	public ParkingCharge(Client client) {
		this.client = client;
	}
	
	// Getters e setters

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public PaymentTicket getPaymentTicket() {
		return paymentTicket;
	}

	public void setPaymentTicket(PaymentTicket paymentTicket) {
		this.paymentTicket = paymentTicket;
	}
	
	// Métodos da classe
	
	@Override
	public String toString() {
		return client.getName() + " - " + client.getCpf()
				+ "\nModelo do carro: " + client.getVehicle().getVehicle() + " - Placa: " + client.getVehicle().getLicensePlate()
				+ "\nEntrada/Saída: " + paymentTicket.getEntryMoment().format(fmt) + " - " + paymentTicket.getExitMoment().format(fmt)
				+ "\nValor a ser pago: R$" + String.format("%.2f", paymentTicket.getBasicPayment());
	}

}
