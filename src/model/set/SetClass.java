package model.set;

import model.note.Note;

/**
 * @author Geoffrey Liu
 */
public interface SetClass<E extends Note> extends Iterable<E> {
	
	/**
	 * Retrieves the interval vector for this set class
	 * @return the interval vector for this set class
	 */
	public IntervalVector getIntervalVector();

}
