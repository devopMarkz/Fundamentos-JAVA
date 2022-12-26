package services;

import java.time.Duration;
import java.time.LocalDateTime;

import entities.ParkingCharge;
import entities.PaymentTicket;

public class PaymentTicketProcessingService {
	
	private FeeService fee;
	
	public PaymentTicketProcessingService(FeeService fee) {
		this.fee = fee;
	}

	public FeeService getFee() {
		return fee;
	}

	public void setFee(FeeService fee) {
		this.fee = fee;
	}

	public void processPaymentTicket(ParkingCharge parkingCharge, LocalDateTime entryMoment, LocalDateTime exitMoment) {
		double parkingTime = Math.ceil(Duration.between(entryMoment, exitMoment).toMinutes() / 60.0);
		double basicPayment = parkingTime * getFee().getTax();
		
		parkingCharge.setPaymentTicket(new PaymentTicket(basicPayment, entryMoment, exitMoment));
	}	

}
