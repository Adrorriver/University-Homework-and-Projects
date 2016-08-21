/*
 * Class represents an AirPort with relevant methods
 */
public class AirPort {
	private String name;
	private int runWayCount;
	private boolean[] occupyRunWays;
	private int coutOccupyRunWays;

	public AirPort(String name, int runWayCount) {
		super();
		this.name = name;
		this.runWayCount = runWayCount;
		occupyRunWays = new boolean[runWayCount];
		coutOccupyRunWays = 0;
	}

	public String getName() {
		return name;
	}

	public int getRunWayCount() {
		return runWayCount;
	}

	public int depart(int flightNum) {
		check();
		int runWay = getRunWay();
		System.out.println("flight number :" + flightNum + " departure from " + getName() + " on runway:" + runWay);
		return runWay;
	}

	public synchronized void check() {
		while (!(coutOccupyRunWays < runWayCount)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		coutOccupyRunWays++;
	}

	private int getRunWay() {
		for (int i = 0; i < occupyRunWays.length; i++) {
			if (occupyRunWays[i] == false) {
				occupyRunWays[i] = true;
				return i + 1;
			}
		}
		System.out.println("error!!!!!!");
		return 0;
	}

	public int land(int flightNum) {
		check();
		int runWay = getRunWay();
		System.out.println("flight number :" + flightNum + " landed at " + getName() + " on runway:" + runWay);
		return runWay;
	}

	public synchronized void freeRunway(int flightNum, int runWayNum) {
		occupyRunWays[runWayNum - 1] = false;
		coutOccupyRunWays--;
		notifyAll();
		System.out.println("flight number :" + flightNum + " at " + getName() + " free runway: " + runWayNum);
	}
}
