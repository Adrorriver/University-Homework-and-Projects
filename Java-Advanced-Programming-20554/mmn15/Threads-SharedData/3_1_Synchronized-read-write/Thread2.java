public class Thread2 implements Runnable {
	SharedData data;
	private static final int TIMES = 10;
	private static final int SLEEP_TIME = 50;
	
	public Thread2(SharedData data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		for (int i = 0; i < TIMES; i++) {
			System.out.println("calc result: "+data.calc());
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				System.out.println("\ninterrupted");
				e.printStackTrace();
			}
		}
	}
}

