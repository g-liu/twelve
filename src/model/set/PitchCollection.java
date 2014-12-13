package model.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import model.note.Note;

/**
 * @author Geoffrey Liu
 */
public class PitchCollection<E extends Note> extends AbstractSetClass<E> {
	
	private Set<E> pitchCollection;

	/**
	 * Creates a new PitchCollection
	 * TODO doc 
	 */
	public PitchCollection(E[] pitches) {
		pitchCollection = new LinkedHashSet<E>();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
