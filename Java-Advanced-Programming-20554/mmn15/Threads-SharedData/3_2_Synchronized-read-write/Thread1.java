import java.security.SecureRandom;

public class Thread1 implements Runnable {
	SharedData data;
	private static final int TIMES = 10;
	private static final int BOUND = 500;
	private static final int SLEEP_TIME = 50;
	
	public Thread1(SharedData data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		SecureRandom rand = new SecureRandom();
		for (int i = 0; i < TIMES; i++) {
			int x = rand.nextInt(BOUND);
			int y = rand.nextInt(BOUND);
			data.store(x, y);
			System.out.println("store x= "+x+", y= "+y);
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				System.out.println("\ninterrupted");
				e.printStackTrace();
			}
		}
	}
}

