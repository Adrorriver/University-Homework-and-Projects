/*
 * class represent a position point whit x and y coordinate ,  
 */
public class Position {
	private int _x;
	private int _y;

	public Position(int x, int y) {
		super();
		this._x = x;
		this._y = y;
	}

	public int get_x() {
		return _x;
	}

	public void set_x(int x) {
		this._x = x;
	}

	public int get_y() {
		return _y;
	}

	public void set_y(int y) {
		this._y = y;
	}

}
