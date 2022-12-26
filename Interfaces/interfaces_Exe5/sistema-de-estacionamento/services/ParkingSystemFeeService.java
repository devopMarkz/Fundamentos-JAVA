package services;

public class ParkingSystemFeeService implements FeeService {

	@Override
	public Double getTax() {
		return 5.0;
	}

}
