
/*
 * Class represents a Flight with relevant methods
 */
import java.security.SecureRandom;

public class Flight implements Runnable {
	int flightNum;
	AirPort departureAirport;
	AirPort arrivaleAirport;
	SecureRandom rand = new SecureRandom();

	private static final int DEPART_LAND_MIN = 2;
	private static final int DEPART_LAND_BOUND = 3;
	private static final int FLIGHT_MIN = 4;
	private static final int FLIGHT_BOUND = 20;

	public Flight(int flightNum, AirPort departureAirport, AirPort arrivaleAirport) {
		super();
		this.flightNum = flightNum;
		this.departureAirport = departureAirport;
		this.arrivaleAirport = arrivaleAirport;
	}

	@Override
	public void run() {
		int runway = departureAirport.depart(flightNum);
		try {
			Thread.sleep(rand.nextInt(DEPART_LAND_BOUND) + DEPART_LAND_MIN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		departureAirport.freeRunway(flightNum, runway);
		try {
			Thread.sleep(rand.nextInt(FLIGHT_BOUND) + FLIGHT_MIN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		runway = arrivaleAirport.land(flightNum);
		try {
			Thread.sleep(rand.nextInt(DEPART_LAND_BOUND) + DEPART_LAND_MIN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		arrivaleAirport.freeRunway(flightNum, runway);

	}
}
