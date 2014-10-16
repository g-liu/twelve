package twelve;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * A ToneRow class.
 * @author Geoffrey Liu
 */
public class ToneRow {
	private Set<PitchClass> rowSet;
	
	/**
	 * Create a new empty ToneRow
	 */
	public ToneRow() {
		rowSet = new TreeSet<PitchClass>();
		checkRep();
	}
	
	/**
	 * Create a new ToneRow using elements from an existing ArrayList.
	 * @param rowArray the ArrayList containing pitch classes
	 */
	public ToneRow(ArrayList<PitchClass> rowArray) {
		// TODO: Implementation
	}
	
	@Override
	public String toString() {
		return rowSet.toString();
	}
	
	private void checkRep() {
		// TODO: Make sure that the ToneRow contains all twelve pitch classes.
	}
}
