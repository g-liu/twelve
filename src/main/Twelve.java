/**
 * 
 */
package main;

import java.util.Arrays;

import twelve.NamedNote;
import twelve.ToneRow;

/**
 * Run the program
 * @author Geoffrey Liu
 */
public class Twelve {
	
	private static ToneRow tr;

	/**
	 * @param args
	 */
	public static void main(String[] argv) {
		// TODO Auto-generated method stub
		NamedNote[] notes = parseArgs(argv); 
		System.out.println(Arrays.toString(notes));
		tr = new ToneRow(notes);
	}
	
	/**
	 * Takes the user inputted args and returns a new NamedNote array
	 * @param argv
	 * @return the NamedNote array from the user args
	 */
	public static NamedNote[] parseArgs(String[] argv) {
		if(argv.length == 12) {
			NamedNote[] addToRow = new NamedNote[12];
			int i = 0;
			for(String noteName : argv) {
				try {
					NamedNote toAdd = new NamedNote(noteName);
					addToRow[i++] = toAdd;
				}
				catch(IllegalArgumentException iae) {
					iae.printStackTrace();
				}
			}
			return addToRow;
		}
		return null;
	}

}
