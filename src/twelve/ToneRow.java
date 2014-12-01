package twelve;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A ToneRow class. Immutable.
 * 
 * Representation Invariant: No two Notes may have the same PitchClass. This is
 * 	enforced by the Set-backed structure of the ToneRow.
 * @author Geoffrey Liu
 */
public class ToneRow<E extends Note> {
	
	/** The tone row */
	private Set<E> rowSet;
	
	/** Internal debug flag */
	private final boolean DEBUG = false;
	
	/**
	 * Create a new ToneRow using elements from an existing NamedNote array
	 * @param rowArray the array containing the notes
	 */
	public ToneRow(E[] rowArray) {
		if(rowArray.length != 12) {
			throw new IllegalArgumentException("Tone row must consist of exactly 12 notes");
		}
		
		rowSet = new LinkedHashSet<E>();
		for(E n: rowArray) {
			rowSet.add(n);
		}
		checkRep();
	}
	
	/**
	 * Returns the retrograde form of this tone row
	 * @return the tone row, in retrograde
	 */
	@SuppressWarnings("unchecked")
	public ToneRow<E> retrograde() {
		List<E> sort = new ArrayList<E>(rowSet);
		Collections.reverse(sort);
		return new ToneRow<E>((E[]) sort.toArray());
	}
	
	/**
	 * Returns the inversion of this tone row
	 * @return the tone row, inverted
	 */
	public ToneRow<E> inversion() {
		// TODO: Implement
		return null;
		
	}
	
	/**
	 * Returns the retrograde inversion of this tone row
	 * @return the row, in retrograde inversion form
	 */
	public ToneRow<E> retrogradeInversion() {
		return this.retrograde().inversion();
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		// TODO: Custom implementation for command line
		return rowSet.toString();
	}
	
	/**
	 * Internal method to check the representation
	 */
	private void checkRep() {
		if(DEBUG) {
			assert rowSet.size() == 12 : "Row does not have 12 pitches";
			assert !rowSet.contains(null) : "Row cannot have a `null` element";
		}
	}
}
