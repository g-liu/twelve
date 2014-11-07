/**
 * 
 */
package main;

import twelve.Note;
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
		Note[] notes = parseArgs(argv); 
		tr = new ToneRow(notes);
	}
	
	/**
	 * Takes the user inputted args and returns a new Note array
	 * @param argv
	 * @return
	 */
	public static Note[] parseArgs(String[] argv) {
		if(argv.length > 0 && (argv[0] == "--help" || argv[0] == "-h")) {
			printHelp();
		}
		
		if(argv.length == 12) {
			Note[] addToRow = new Note[12];
			int i = 0;
			for(String noteName : argv) {
				try {
					Note toAdd = new Note(noteName);
					addToRow[i++] = toAdd;
				}
				catch(IllegalArgumentException iae) {
					iae.printStackTrace();
				}
			}
			
			tr = new ToneRow(addToRow);
			
			System.out.println("Tone row added");
		}
		return null;
	}
	
	public static void printHelp() {
		System.out.println("Usage: java Twelve [args]");
	}

}
