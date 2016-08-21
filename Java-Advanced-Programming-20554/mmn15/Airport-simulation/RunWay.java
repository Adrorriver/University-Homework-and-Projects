/*
 * Class represents a RunWay with relevant methods
 */
public class RunWay {
	private final int runWayNum;
	private boolean occupy;

	public RunWay(int runWayNum) {
		super();
		this.runWayNum = runWayNum;
		this.occupy = false;
	}

	public int getRunWayNum() {
		return runWayNum;
	}

	public boolean isOccupy() {
		return occupy;
	}

	public void setOccupy(boolean occupy) {
		this.occupy = occupy;
	}

}
