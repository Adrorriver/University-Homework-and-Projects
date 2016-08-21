/* another implementation white: synchronized wait and notifyAll. */

public class SharedData {
	private double x = 0;
	private double y = 0;
	private int readers = 0;
	private int writers = 0;
	private int writeRequests = 0;

	public double calc() {
		lockRead();
		try {
			return (x + y) / 2;
		} finally {
			unLockRead();
		}

	}

	private synchronized void lockRead() {
		while (writers > 0 || writeRequests > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		readers++;
	}

	private synchronized void unLockRead() {
		readers--;
		notifyAll();
	}

	public void store(double x, double y) {
		lockWrite();
		try {
			this.x = x;
			this.y = y;
		} finally {
			unLockWrite();
		}
	}

	private synchronized void lockWrite() {
		writeRequests++;

		while (readers > 0 || writers > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		writeRequests--;
		writers++;
	}

	private synchronized void unLockWrite() {
		writers--;
		notifyAll();

	}
}
