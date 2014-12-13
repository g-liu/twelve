package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import twelve.NamedNote;
import twelve.ToneRow;

/**
 * Run the program
 * @author Geoffrey Liu
 */
public class Twelve {
	
	/**
	 * Holds a representation of the ToneRow matrix.
	 * Each entry represents a row in the matrix.
	 */
	private static List<ToneRow<NamedNote>> rowMatrix;

	/**
	 * @param args command-line args
	 */
	public static void main(String[] argv) {
		Scanner s = new Scanner(System.in);
		List<NamedNote> notes = new ArrayList<NamedNote>(12);
		if(argv.length != 12) {
			// prompt user from system.in
			System.out.println("Enter notes (q to quit)");
			String rawInput;
			for(int i = 0; i < 12; i++) {
				NamedNote named = null;
				while(named == null || notes.contains(named)) {
					System.out.print(String.format("Note %d: ", i + 1));
					rawInput = s.nextLine();
					try {
						named = new NamedNote(rawInput);
					}
					catch(IllegalArgumentException iae) {
						named = null;
						System.err.println("Invalid note: " + rawInput);
					}
				}
				notes.add(named);
			}
			s.close();
		}
		else {
			notes = parseArgs(argv);
		}
		
		assert notes.size() == 12;
		rowMatrix = new ArrayList<ToneRow<NamedNote>>(12);
		
		ToneRow<NamedNote> base = new ToneRow<NamedNote>(notes);
		rowMatrix.add(base);
		for(int i = 1; i < 12; i++) {
			int interval = base.first().intervalTo(base.get(i));
			rowMatrix.add(base.transposition(interval));
		}
		
		printMatrix(rowMatrix);
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

	private static void printMatrix(List<ToneRow<NamedNote>> mat) {
		for(ToneRow<NamedNote> row : mat) {
			System.out.println("-------------------------------------");
			System.out.print("|");
			for(NamedNote note : row) {
				System.out.print(String.format("%1$-2s|", note.toString()));
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
}
