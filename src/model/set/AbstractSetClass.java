package model.set;

import model.note.Note;

/**
 * @author Geoffrey Liu
 */
public abstract class AbstractSetClass<E extends Note> implements SetClass<E> {
	
	@Override
	public IntervalVector getIntervalVector() {
		return new IntervalVector(this);
	}

}
