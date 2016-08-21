/*
 *  New Exceptions defined for this project
 *  
 *  this Exception throws when there is an attempt to make an action 
 *  on illegal position
 */
public class PositionNotValidException extends IllegalPositionException {

	private static final long serialVersionUID = 2L;

	public PositionNotValidException() {
		super();
	}

	public PositionNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public PositionNotValidException(String message) {
		super(message);
	}

	public PositionNotValidException(Throwable cause) {
		super(cause);
	}
}
