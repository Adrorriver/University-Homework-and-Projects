
/*
 * class represent a Robot with all of it's attributes  
 */
import java.awt.Graphics;

public class Robot {
	private int id;
	private Position position;
	private int direction;

	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;

	private static final int CELL_SIZE = 20;
	private static final int CORRECTION_X = 8;
	private static final int CORRECTION_Y = 16;

	public Robot(int id, Position position, int direction) {
		super();
		this.id = id;
		this.position = position;
		this.direction = direction;
	}

	public void move() {
		switch (direction) {
		case UP:
			position.set_y(position.get_y() - 1);
			break;
		case RIGHT:
			position.set_x(position.get_x() + 1);
			break;
		case DOWN:
			position.set_y(position.get_y() + 1);
			break;
		case LEFT:
			position.set_x(position.get_x() - 1);
			break;
		}
	}

	public void turnLeft() {
		if (direction == UP) {
			direction = LEFT;
		} else {
			direction--;
		}
	}

	public void turnRigth() {
		if (direction == LEFT) {
			direction = UP;
		} else {
			direction++;
		}
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void drawRobot(Graphics g) {
		g.drawOval(position.get_x() * CELL_SIZE, position.get_y() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
		if (direction == UP) {
			g.drawString("^", position.get_x() * CELL_SIZE + CORRECTION_X, position.get_y() * CELL_SIZE + CORRECTION_Y);
		} else if (direction == RIGHT) {
			g.drawString(">", position.get_x() * CELL_SIZE + CORRECTION_X, position.get_y() * CELL_SIZE + CORRECTION_Y);
		} else if (direction == DOWN) {
			g.drawString("v", position.get_x() * CELL_SIZE + CORRECTION_X, position.get_y() * CELL_SIZE + CORRECTION_Y);
		} else {
			g.drawString("<", position.get_x() * CELL_SIZE + CORRECTION_X, position.get_y() * CELL_SIZE + CORRECTION_Y);
		}
	}
}
