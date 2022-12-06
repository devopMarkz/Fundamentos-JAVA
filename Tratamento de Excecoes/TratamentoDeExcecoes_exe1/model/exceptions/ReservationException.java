package model.exceptions;

public class ReservationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ReservationException (String msgErro) {
		super(msgErro);
	}

}
