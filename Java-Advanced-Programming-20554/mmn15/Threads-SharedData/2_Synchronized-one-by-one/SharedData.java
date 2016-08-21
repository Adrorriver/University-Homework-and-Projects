
public class SharedData {
	private double x = 0;
	private double y = 0;
	private boolean calcFlag = false;

	public double calc() {
		while (!calcFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (this) {
			calcFlag = false;
			notify();
			return (x + y) / 2;
		}

	}

	public void store(double x, double y) {
		while (calcFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (this) {
			this.x = x;
			this.y = y;
			calcFlag = true;
			notify();
		}
	}
}
