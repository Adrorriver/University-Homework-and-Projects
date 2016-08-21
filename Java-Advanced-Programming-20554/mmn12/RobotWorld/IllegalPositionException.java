/*
 *  abstract class. this is the super class of PositionNotValidException and
 *  RobotCantMoveException, 2 new Exceptions defined for this project
 *  
 */
public abstract class IllegalPositionException extends Exception{
	private static final long serialVersionUID = 1L;

	public IllegalPositionException() {
		super();
	}

	public IllegalPositionException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalPositionException(String message) {
		super(message);
	}

	public IllegalPositionException(Throwable cause) {
		super(cause);
	}
	
}
