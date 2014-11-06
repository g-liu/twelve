/**
 * 
 */
package main;

import twelve.Note;
import twelve.ToneRow;

/**
 * @author Geoffrey
 *
 */
public class Twelve {
	
	private static ToneRow tr;

	/**
	 * @param args
	 */
	public static void main(String[] argv) {
		// TODO Auto-generated method stub
		if(argv[0] == "--help" || argv[0] == "-h") {
			printHelp();
		}
		
		// TODO: For now, assume user calls Twelve with 12 notes
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
			
			System.out.println(tr);
		}
	}
	
	public static void printHelp() {
		System.out.println("Usage: java Twelve [args]");
	}

}
