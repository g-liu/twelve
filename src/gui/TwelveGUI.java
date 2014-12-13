package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author Geoffrey Liu
 */
public class TwelveGUI {

	/**
	 * Creates the application
	 */
	public TwelveGUI() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("Twelve-tone analyzer");
		JPanel container = new JPanel();
		
		frame.add(container);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setVisible(true);
	}

}
