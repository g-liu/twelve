package model.set;

import model.note.Note;

/**
 * Abstract implementation of a general set class.
 * 
 * @author Geoffrey Liu
 */
public abstract class AbstractSetClass<E extends Note> implements SetClass<E> {

	@Override
	public IntervalVector getIntervalVector() {
		return new IntervalVector(this);
	}

}
