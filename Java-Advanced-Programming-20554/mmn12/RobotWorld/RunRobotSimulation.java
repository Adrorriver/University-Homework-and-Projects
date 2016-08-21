
/*
 * class for testing the RobotWorld project, contains the logics for the simulation
 */
import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RunRobotSimulation {

	private Robot[] robotArr = new Robot[NUM_OF_ROBOT];
	private SecureRandom randomNumbers = new SecureRandom();
    
	private static final int NUM_OF_ROBOT = 30;
	private static final int NUM_OF_ROBOT_STEPS = 1000;
	private static final int FIRST_ROBOT = 0;
	private static final int NUM_OF_DIRACTION = 4;
	private static final int SLEEP_TIME = 200;

	public void run() {
		try {
			runSimulation();
			// Handles Exceptions that may occur from java.lang.Thread.sleep(),
			// Exception("Robot stuck") defined in runSimulation
			// and any other unexpected Exception
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println("program exit");
		}
	}

	public void runSimulation() throws Exception {
		int size = getSizeFromUser();

		RobotWorld robotW = new RobotWorld(size);
		// create NUM_OF_ROBOT robots, in case of Exception print the Exception,
		// and doesn't create the Robot
		for (int i = 0; i < NUM_OF_ROBOT; i++) {
			try {
				Position p = new Position(randomNumbers.nextInt(size), randomNumbers.nextInt(size));
				robotW.addRobot(p);
				robotArr[i] = robotW.getRobot(p);
			} catch (Exception exc) {
				System.out.println(exc.getMessage());
			}
		}
		DrawPanel panel = new DrawPanel(robotW);
		JFrame application = new JFrame();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add the panel to the frame
		application.add(panel);
		application.setSize(800, 800);
		application.setVisible(true);

		// move the first Robot NUM_OF_ROBOT_STEPS. draw the panel after each
		// move. and check if the robot stuck
		int stuckCunt = 0;
		for (int i = 0; i < NUM_OF_ROBOT_STEPS; i++) {
			try {
				java.lang.Thread.sleep(SLEEP_TIME);
				robotW.moveRobot(robotArr[FIRST_ROBOT].getPosition());
				application.repaint();
				stuckCunt = 0;

			} catch (IllegalPositionException exp) {
				if (exp instanceof RobotCantMoveException) {
					robotArr[FIRST_ROBOT].turnRigth();
					application.repaint();
					i--;
					if (stuckCunt >= NUM_OF_DIRACTION) {
						throw new Exception("Robot stuck");
					}
					stuckCunt++;
				} else if (exp instanceof PositionNotValidException) {
					i--;
				}
			}
		}
	}

	// get an integer from the user, if there is an illegal input, ask again
	private int getSizeFromUser() {
		int size = 0;
		boolean continueLoop = true;
		do {
			String num = JOptionPane.showInputDialog("Enter integer for world size: ");
			try {
				size = Integer.parseInt(num);
				continueLoop = false;
			} catch (NumberFormatException exc) {
				System.err.printf("%nException: %s%n", exc);
				JOptionPane.showMessageDialog(null, "You must enter integers. Please try again.");
			}
		} while (continueLoop);
		return size;
	}

}
