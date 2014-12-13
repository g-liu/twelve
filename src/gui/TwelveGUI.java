package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author Geoffrey Liu
 */
public class TwelveGUI {
	private JPanel rowDisplay;

	/**
	 * Creates the application
	 */
	public TwelveGUI() {
		JFrame frame = new JFrame("Twelve-tone analyzer");
		
		JPanel noteButtons = new JPanel();
		noteButtons.setLayout(new GridLayout(2, 6, 5, 5));
		
		rowDisplay = new JPanel();
		JPanel matrixDisplay = new JPanel();
		
		JButton[] pitchButtons = new JButton[12];
		String[] buttonLabels = new String[] { "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B" };
		
		for(int i = 0; i < buttonLabels.length; i++) {
			pitchButtons[i] = new JButton(buttonLabels[i]);
			pitchButtons[i].setPreferredSize(new Dimension(100, 100));
			pitchButtons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JButton trigger = (JButton) arg0.getSource();
					trigger.setEnabled(false);
					
					rowDisplay.add(new JLabel(trigger.getText()));
					rowDisplay.revalidate();
					rowDisplay.repaint();
				}
				
			});
			noteButtons.add(pitchButtons[i]);
		}
		
		frame.add(noteButtons, BorderLayout.NORTH);
		frame.add(rowDisplay, BorderLayout.CENTER);
		frame.add(matrixDisplay, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setVisible(true);
	}

}
