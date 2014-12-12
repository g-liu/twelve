/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

import twelve.NamedNote;
import twelve.PitchedNote;
import twelve.ToneRow;

/**
 * Run the program
 * @author Geoffrey Liu
 */
public class Twelve {
	
	private static ToneRow<NamedNote> tr;

	/**
	 * @param args
	 */
	public static void main(String[] argv) {
		Scanner s = new Scanner(System.in);
		NamedNote[] notes = new NamedNote[12];
		if(argv.length != 12) {
			// prompt user from system.in
			for(int i = 0; i < notes.length; i++) {
				System.out.print(String.format("Note %d: ", i + 1));
				notes[i] = new NamedNote(s.nextLine());
			}
			s.close();
		}
		else {
			notes = parseArgs(argv);
		}
		
		assert notes.length == 12;
		
		PitchedNote[] notesPitched = new PitchedNote[12];
		for(int i = 0; i < notes.length; i++) {
			notesPitched[i] = new PitchedNote(notes[i]);
		}
		System.out.println(Arrays.toString(notes));
		tr = new ToneRow<NamedNote>(notes);
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
