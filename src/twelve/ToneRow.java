package twelve;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * A ToneRow class.
 * 
 * Representation Invariant: No two Notes may have the same PitchClass
 * @author Geoffrey Liu
 */
public class ToneRow
{
	private Set<Note> rowSet;
	
	/**
	 * Create a new empty ToneRow
	 */
	public ToneRow() {
		rowSet = new TreeSet<Note>();
		normalize();
		checkRep();
	}
	
	/**
	 * Create a new ToneRow using elements from an existing ArrayList.
	 * @param rowArray the ArrayList containing pitch classes
	 */
	public ToneRow(ArrayList<Note> rowArray) {
		// TODO: Implementation
	}
	
	public void add(Note n) {
		rowSet.add(n);
	}
	
	/**
	 * Normalizes this row such that all pitches are contained within one octave.
	 */
	private void normalize() {
		
	}
	
	public int size() {
		return rowSet.size();
	}
	
	public ToneRow retrograde() {
		// TODO: Implement
		return null;
		
	}
	
	public ToneRow inversion() {
		// TODO: Implement
		return null;
		
	}
	
	public ToneRow retrogradeInversion() {
		return this.retrograde().inversion();
		
	}
	
	@Override
	public String toString() {
		return rowSet.toString();
	}
	
	private void checkRep() {
		// TODO: Make sure that the ToneRow contains all twelve pitch classes.
	}
}
