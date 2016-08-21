
/*
 * class represent a panel to draw the Robot world on. 
 */

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = 4L;
	private static final int CELL_SIZE = 20;

	private int size;
	private Robot[][] matrix;

	public DrawPanel(RobotWorld world) {
		super();
		this.size = world.size;
		this.matrix = world.matrix;
	}

	public void paintComponent(Graphics g) {
		// call paintComponent to ensure the panel displays correctly
		super.paintComponent(g);

		drawMatrix(g);
		drawRobots(g);

	}

	// scan the matrix an draw the Robots. each Robot draw himself
	// using the drawRobot method
	private void drawRobots(Graphics g) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				Robot currentRobot = matrix[i][j];
				if (currentRobot != null) {
					currentRobot.drawRobot(g);
				}
			}
		}

	}

	// draw matrix of size * size cells
	public void drawMatrix(Graphics g) {
		g.drawLine(0, 0, 0, size * CELL_SIZE);
		g.drawLine(0, 0, size * CELL_SIZE, 0);
		g.drawLine(size * CELL_SIZE, size * CELL_SIZE, 0, size * CELL_SIZE);
		g.drawLine(size * CELL_SIZE, size * CELL_SIZE, size * CELL_SIZE, 0);
		for (int i = 1; i < size; i++) {
			g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, size * CELL_SIZE);
			g.drawLine(0, i * CELL_SIZE, size * CELL_SIZE, i * CELL_SIZE);
		}
	}
}
