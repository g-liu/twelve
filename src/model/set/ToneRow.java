package model.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import model.note.Note;

/**
 * A tone row contains all possible pitch classes in a given order. No pitch
 * class is contained twice and no pitch classes are missing. The tone row is a
 * special case of a set class or pitch collection.
 * 
 * @author Geoffrey Liu
 */
public class ToneRow<E extends Note> extends AbstractSetClass<E> {

	/** The tone row */
	private Set<E> rowSet;

	/** Internal debug flag */
	private final boolean DEBUG = false;

	/**
	 * Create a new ToneRow using elements from an existing NamedNote array
	 * 
	 * @param rowArray
	 *            the array containing the notes
	 */
	public ToneRow(E[] rowArray) {
		if (rowArray.length != 12) {
			throw new IllegalArgumentException(
					"Tone row must consist of exactly 12 notes");
		}

		rowSet = new LinkedHashSet<E>(Arrays.asList(rowArray));
		checkRep();
	}

	/**
	 * Create a new ToneRow using elements from an existing
	 * 
	 * @param rowList
	 */
	public ToneRow(List<E> rowList) {
		if (rowList.size() != 12) {
			throw new IllegalArgumentException(
					"Tone row must consist of exactly 12 notes");
		}

		rowSet = new LinkedHashSet<E>(rowList);
		checkRep();
	}

	/**
	 * Retrieve the i-th note in the ToneRow
	 * 
	 * @param i
	 *            the number of notes from the beginning of the tone row. Must
	 *            be in the range of [0..11]
	 * @return the i-th note in the ToneRow
	 */
	public Note get(int i) {
		if (i < 0 || i >= 12) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int currentIndex = 0;
		for (Iterator<E> itr = rowSet.iterator(); itr.hasNext();) {
			Note n = itr.next();
			if (currentIndex++ == i) {
				return n;
			}
		}
		return null;
	}

	/**
	 * Retrieves the first Note of the ToneRow
	 * 
	 * @return the first note
	 */
	public Note first() {
		return rowSet.iterator().next();
	}

	/**
	 * Returns a new ToneRow consisting of the original notes of the tone row
	 * transposed up by the indicated number of half steps.
	 * 
	 * @param the
	 *            interval at which to transpose
	 * @return a new ToneRow as described above, or this if interval == 0
	 */
	public ToneRow<E> transposition(int interval) {
		// ignore spurious requests.
		if (interval == 0) {
			return this;
		}
		List<E> notes = new ArrayList<E>(rowSet);
		for (int i = 0; i < notes.size(); i++) {
			notes.set(i, (E) notes.get(i).transpose(interval));
		}
		return new ToneRow<E>(notes);
	}

	/**
	 * Returns the retrograde form of this tone row
	 * 
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
	 * 
	 * @return the tone row, inverted
	 */
	public ToneRow<E> inversion() {
		List<E> notes = new ArrayList<E>(rowSet);
		for (int i = 0; i < notes.size(); i++) {
			int interval = notes.get(0).intervalTo(notes.get(i));
			notes.set(i, (E) notes.get(0).transpose(-interval));
		}
		return new ToneRow<E>(notes);
	}

	/**
	 * Returns the retrograde inversion of this tone row
	 * 
	 * @return the row, in retrograde inversion form
	 */
	public ToneRow<E> retrogradeInversion() {
		return this.retrograde().inversion();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		return rowSet.iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return rowSet.toString();
	}

	/**
	 * Internal method to check the representation
	 */
	private void checkRep() {
		if (DEBUG) {
			assert rowSet.size() == 12 : "Row does not have 12 pitches";
			assert !rowSet.contains(null) : "Row cannot have a `null` element";
		}
	}
}
