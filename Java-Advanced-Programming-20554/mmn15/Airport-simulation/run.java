/**
 * Class for running simulation
 * 
 * @author (amir dror) 
 * 
 */
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class run {
	static AirPort airport1;
	static AirPort airport2;

	private static final int NUM_OF_FLIGHTS = 10;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		airport1 = new AirPort("airport1", 3);
		airport2 = new AirPort("airport2", 3);

		for (int i = 0; i < NUM_OF_FLIGHTS; i++) {
			AirPort departure = getRandAirport();
			AirPort arrivale;
			if (departure.equals(airport1)) {
				arrivale = airport2;
			} else {
				arrivale = airport1;
			}
			executor.execute(new Flight(i + 1, departure, arrivale));
		}
		executor.shutdown();
	}

	private static AirPort getRandAirport() {
		SecureRandom rand = new SecureRandom();
		if (rand.nextInt(2) == 0) {
			return airport1;
		} else
			return airport2;
	}
}
