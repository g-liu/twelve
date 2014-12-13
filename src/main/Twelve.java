package main;

import java.util.ArrayList;
import java.util.List;

import model.note.NamedNote;
import model.set.ToneRow;
import model.set.ToneRowMatrix;

/**
 * Run the program
 * @author Geoffrey Liu
 */
public class Twelve {
	
	/**
	 * Holds a representation of the ToneRow matrix.
	 * Each entry represents a row in the matrix.
	 */
	private static ToneRowMatrix<NamedNote> rowMatrix;

	/**
	 * @param args command-line args
	 */
	public static void main(String[] argv) {
		List<NamedNote> notes = parseArgs(argv);
		
		assert notes.size() == 12;
		
		ToneRow<NamedNote> base = new ToneRow<NamedNote>(notes);
		rowMatrix = new ToneRowMatrix<NamedNote>(base);
		
		System.out.println(rowMatrix);
	}
	
	/**
	 * Takes the user inputted arguments and returns a new NamedNote array
	 * @param argv
	 * @return the NamedNote array from the user args
	 */
	public static List<NamedNote> parseArgs(String[] argv) {
		List<NamedNote> addToRow = new ArrayList<NamedNote>();

		try {
			for(String noteName : argv) {
				addToRow.add(new NamedNote(noteName));
			}
		}
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		return addToRow;
	}
}
