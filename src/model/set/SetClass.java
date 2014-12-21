package model.set;

import model.note.Note;

/**
 * A set class is a collection of zero or more distinct pitch classes. In
 * Western temperament, set classes are limited to twelve pitch classes, as
 * there exist only twelve pitch classes. A set class which contains all twelve
 * pitches is referred to as a twelve tone row.
 * 
 * @author Geoffrey Liu
 */
public interface SetClass<E extends Note> extends Iterable<E> {

	/**
	 * Retrieves the interval vector for this set class
	 * 
	 * @return the interval vector for this set class
	 */
	public IntervalVector getIntervalVector();

}
