/**
 * runs the GUI App for notes
 * 
 * @author (amir dror) 
 */
import javax.swing.JFrame;

public class run {
	public static void main (String[] args){
		App app = new App();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(400, 400);
		app.setVisible(true);
	}
}
