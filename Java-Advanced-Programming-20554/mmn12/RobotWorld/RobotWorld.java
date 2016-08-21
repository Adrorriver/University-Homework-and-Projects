/*
 * class represent RobotWorld a board for the Robot to be placed on   
 */
import java.security.SecureRandom;

public class RobotWorld {
	Robot[][] matrix;
	int size;
	private SecureRandom randomNumbers = new SecureRandom();
	
	public static int robotId = 1;
	public static final int DEFAULT_SIZE = 20;
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 99;
	public static final int MAX_DIRECTION = 4;

	public RobotWorld(int size) {
		super();
		if (size < MIN_SIZE || size > MAX_SIZE) {
			size = DEFAULT_SIZE;
		}
		this.size = size;
		matrix = new Robot[size][size];
	}
	
	//add robot to the world, in a random place.if the position is illegal
	//throws exception
	public void addRobot(Position p) throws IllegalPositionException {
		if (!robotNotFound(p) || robotOutOfBound(p)) {
			throw new PositionNotValidException("addrobot-PositionNotValidException");
		} else {
			matrix[p.get_x()][p.get_y()] = new Robot(robotId, new Position(p.get_x(), p.get_y()),
					randomNumbers.nextInt(MAX_DIRECTION));
			robotId++;
		}
	}

	public Robot removeRobot(Position p) {
		if (robotNotFound(p) || robotOutOfBound(p)) {
			return null;
		} else {
			Robot tmp;
			tmp = matrix[p.get_x()][p.get_y()];
			matrix[p.get_x()][p.get_y()] = null;
			return tmp;
		}
	}

	public Robot getRobot(Position p) {
		if (robotNotFound(p) || robotOutOfBound(p)) {
			return null;
		} else {
			return matrix[p.get_x()][p.get_y()];
		}
	}
	
	// move Robot only if the current position is legal, and the position 
	// of the Robot after the move is legal
	public void moveRobot(Position p) throws IllegalPositionException {
		if (robotNotFound(p) || robotOutOfBound(p)) {
			throw new PositionNotValidException("PositionNotValidException");
		} else {
			Position undo = new Position(p.get_x(), p.get_y());
			Robot tmp = removeRobot(p);
			tmp.move();
			if (robotOutOfBound(tmp.getPosition()) || !robotNotFound(tmp.getPosition())) {
				tmp.setPosition(undo);
				insertRobot(tmp);
				throw new RobotCantMoveException("RobotCantMoveException");
			} else {
				insertRobot(tmp);
			}
		}
	}
	
	//insert an existed Robot to the board. doesn't make a new robot like the add method
	private void insertRobot(Robot rob) {
		matrix[rob.getPosition().get_x()][rob.getPosition().get_y()] = rob;
	}

	private boolean robotNotFound(Position p) {
		if (matrix[p.get_x()][p.get_y()] == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean robotOutOfBound(Position p) {
		if (p.get_x() > size - 1 || p.get_x() < 0 || p.get_y() > size - 1 || p.get_y() < 0) {
			return true;
		} else {
			return false;
		}
	}
}
