package model.set;

import java.util.Map;

import model.note.Note;

/**
 * An interval vector is an array that expresses the intervallic content of a
 * pitch-class set.
 * 
 * Internally, the IntervalVector class contains a mapping between intervals and
 * their counts.
 * 
 * @author Geoffrey Liu
 *
 */
public class IntervalVector {

	/** The intervals, represented by a mapping from interval => count */
	private Map<Integer, Integer> intervals;

	/**
	 * Constructs a "blank" interval vector by initializing all counts to zero
	 */
	public IntervalVector() {
		for (int i = 1; i <= 6; i++) {
			intervals.put(i, 0);
		}
	}

	/**
	 * Creates the IntervalVector from a given SetClass
	 * 
	 * @param row
	 */
	public <E extends Note> IntervalVector(SetClass<E> row) {
		// TODO: Implement
	}

	/**
	 * Add an interval to the interval vector. Ignores unisons and octaves
	 * 
	 * @param interval
	 *            the interval
	 */
	private void add(int interval) {
		// ignore unisons and octaves
		if (interval % 12 == 0) {
			return;
		}
		// TODO: normalize intervals to be within a minor second and a tritone,
		// inclusive.

		assert interval >= 1 && interval <= 6;
		intervals.put(interval, intervals.get(interval) + 1);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof IntervalVector)) {
			return false;
		}
		IntervalVector ivo = (IntervalVector) o;
		return this.intervals.equals(ivo.intervals);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return intervals.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return String.format("<%d, %d, %d, %d, %d, %d>", intervals.get(1),
				intervals.get(2), intervals.get(3), intervals.get(4),
				intervals.get(5), intervals.get(6));
	}

}
