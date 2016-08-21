/*
 *  New Exceptions defined for this project
 *  
 *  this Exception throws when there is an attempt to move a Robot 
 *  to illegal position
 */
public class RobotCantMoveException extends IllegalPositionException {

	private static final long serialVersionUID = 3L;

	public RobotCantMoveException() {
		super();
	}

	public RobotCantMoveException(String message, Throwable cause) {
		super(message, cause);
	}

	public RobotCantMoveException(String message) {
		super(message);
	}

	public RobotCantMoveException(Throwable cause) {
		super(cause);
	}
}
