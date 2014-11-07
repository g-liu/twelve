package twelve;

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
public class ToneRow
{
	private Set<NamedNote> rowSet;
	
	private final boolean DEBUG = false;
	
	/**
	 * Create a new ToneRow using elements from an existing NamedNote array
	 * @param rowArray the array containing the notes
	 */
	public ToneRow(NamedNote[] rowArray) {
		for(NamedNote n: rowArray) {
			rowSet.add(n);
		}
		this.normalize();
		checkRep();
	}
	
	/**
	 * Normalizes this row such that all pitches are contained within one octave.
	 */
	private void normalize() {
		// TODO: Implement
		throw new UnsupportedOperationException("Error: Not yet implemented");
	}
	
	/**
	 * Returns the retrograde form of this tone row
	 * @return the tone row, in retrograde
	 */
	public ToneRow retrograde() {
		// TODO: Implement
		return null;
		
	}
	
	/**
	 * Returns the inversion of this tone row
	 * @return the tone row, inverted
	 */
	public ToneRow inversion() {
		// TODO: Implement
		return null;
		
	}
	
	/**
	 * Returns the retrograde inversion of this tone row
	 * @return the row, in retrograde inversion form
	 */
	public ToneRow retrogradeInversion() {
		return this.retrograde().inversion();
		
	}
	
	@Override
	public String toString() {
		return rowSet.toString();
	}
	
	private void checkRep() {
		if(DEBUG) {
			assert rowSet.size() == 12 : "Row does not have 12 pitches";
			assert !rowSet.contains(null) : "Row cannot have a `null` element";
		}
	}
}
