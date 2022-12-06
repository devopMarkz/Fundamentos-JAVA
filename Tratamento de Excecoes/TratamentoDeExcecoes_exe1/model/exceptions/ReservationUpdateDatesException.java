package model.exceptions;

public class ReservationUpdateDatesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ReservationUpdateDatesException (String msgErro) {
		super(msgErro);
	}

}
