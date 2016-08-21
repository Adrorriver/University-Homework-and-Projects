
/**
 * GUI App for notes
 * 
 * @author (amir dror) 
 */

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class App extends JFrame {

	private HashMap<Date, String> map;
	private Date courentDate;
	private Note courentNote;
	ObjectOutputStream out = null;
	ObjectInputStream in = null;
	private final JComboBox<Integer> dayJComboBox;
	private final JComboBox<Integer> monthJComboBox;
	private final JComboBox<Integer> yearJComboBox;
	private JTextArea text;
	private JButton saveBoutton;
	private JButton openBoutton;
	private JButton saveToFileBoutton;

	private static final int DAYS_RANGE = 31;
	private static final int MONTHS_RANGE = 12;
	private static final int YEAR_RANGE = 100;
	private static final int YEAR_MIN = 2000;
	private static final int DEFAULT_DAY_MONTH = 1;
	private static final int NOTE_NUM_OF_COL = 20;
	private static final int NOTE_NUM_OF_ROW = 5;

	private static final Integer[] daysArr = new Integer[DAYS_RANGE];
	private static final Integer[] monthsArr = new Integer[MONTHS_RANGE];
	private static final Integer[] yearsArr = new Integer[YEAR_RANGE];
	private final GridBagLayout layout;
	private final GridBagConstraints constraints;

	public App() { // Construct the Application
		super("notes app");
		map = new HashMap<Date, String>();
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		initiate();// initiate
		String tmp = JOptionPane.showInputDialog("do you want to open file: <y/n>");
		if (tmp.equals("y")) {
			loadFile();
		}
		dayJComboBox = new JComboBox<Integer>(daysArr);
		monthJComboBox = new JComboBox<Integer>(monthsArr);
		yearJComboBox = new JComboBox<Integer>(yearsArr);
		JComboBoxHandler boxHandl = new JComboBoxHandler();
		JButtonHandler buttonHandl = new JButtonHandler();
		dayJComboBox.addItemListener(boxHandl);
		monthJComboBox.addItemListener(boxHandl);
		yearJComboBox.addItemListener(boxHandl);
		saveBoutton.addActionListener(buttonHandl);
		openBoutton.addActionListener(buttonHandl);
		saveToFileBoutton.addActionListener(buttonHandl);

		constraints.fill = GridBagConstraints.BOTH;
		addComponent(text, 1, 0, 3, 1);
		addComponent(dayJComboBox, 0, 0, 1, 1);
		addComponent(monthJComboBox, 0, 1, 1, 1);
		addComponent(yearJComboBox, 0, 2, 1, 1);
		addComponent(saveBoutton, 3, 0, 1, 1);
		addComponent(openBoutton, 3, 1, 1, 1);
		addComponent(saveToFileBoutton, 3, 2, 1, 1);
	}

	private class JButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == saveBoutton) {
				map.put(new Date(courentDate), text.getText());
			} else if (e.getSource() == openBoutton) {
				text.setText(map.get(courentDate));
			} else if (e.getSource() == saveToFileBoutton) {
				fileSave();
			}
		}

	}

	private class JComboBoxHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getSource() == dayJComboBox) {
					courentDate.setDay((int) e.getItem());
				} else if (e.getSource() == monthJComboBox) {
					courentDate.setMonth((int) e.getItem());
				} else if (e.getSource() == yearJComboBox) {
					courentDate.setYear((int) e.getItem());
				}
			}
		}

	}

	private void initiate() {
		initDays();
		initMonths();
		initYears();
		text = new JTextArea(NOTE_NUM_OF_ROW, NOTE_NUM_OF_COL);
		saveBoutton = new JButton("save note");
		openBoutton = new JButton("open note");
		saveToFileBoutton = new JButton("save to file");
		// default date 1.1.2000
		courentDate = new Date(DEFAULT_DAY_MONTH, DEFAULT_DAY_MONTH, YEAR_MIN);
	}

	private void initYears() {
		for (int i = YEAR_MIN; i < YEAR_MIN + YEAR_RANGE; i++) {
			yearsArr[i - YEAR_MIN] = i;
		}
	}

	private void initMonths() {
		for (int i = 1; i <= MONTHS_RANGE; i++) {
			monthsArr[i - 1] = i;
		}

	}

	private void initDays() {
		for (int i = 1; i <= DAYS_RANGE; i++) {
			daysArr[i - 1] = i;
		}
	}

	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints); // set constraints
		add(component);
	}

	private void loadFile() {
		openFileL();
		readNotes();
		closeFileL();
		JOptionPane.showMessageDialog(null, "file loaded successfully");
	}

	private void fileSave() {
		openFileS();
		addNotes();
		closeFileS();
		JOptionPane.showMessageDialog(null, "file saved successfully");
	}

	private void openFileS() {
		String tmp = JOptionPane.showInputDialog("\nenter file name: ");
		try {
			out = new ObjectOutputStream(Files.newOutputStream(Paths.get(tmp)));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
			System.exit(1); // terminate the program
		}
	}

	private void addNotes() {
		Iterator<Map.Entry<Date, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Date, String> entry = it.next();
			courentNote = new Note(entry.getKey(), entry.getValue());
			try {
				out.writeObject(courentNote);
			} catch (IOException e) {
				System.err.println("Error writing to file. Terminating.");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	private void closeFileS() {
		try {
			if (out != null)
				out.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}

	private void openFileL() {
		String tmp = JOptionPane.showInputDialog("\nenter name of file: ");
		try // open file
		{
			in = new ObjectInputStream(Files.newInputStream(Paths.get(tmp)));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	private void readNotes() {
		try {
			while (true) // loop until there is an EOFException
			{
				courentNote = (Note) in.readObject();
				map.put(courentNote.getDate(), courentNote.getMsg());
			}
		} catch (EOFException endOfFileException) {
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Terminating.");
			System.exit(1);
		} catch (IOException ioException) {
			System.err.println("Error reading from file. Terminating.");
			System.exit(1);
		}
	}

	private void closeFileL() {
		try {
			if (in != null)
				in.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
			System.exit(1);
		}
	}
}