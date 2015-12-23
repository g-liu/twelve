package model.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import model.note.Note;

/**
 * A pitch collection is a set of distinct pitch classes.
 * 
 * @author Geoffrey Liu
 */
public class PitchCollection<E extends Note> extends AbstractSetClass<E> {

	/** The pitch collection */
	private Set<E> pitchCollection;

	/**
	 * Creates a new PitchCollection TODO doc
	 */
	public PitchCollection(E[] pitches) {
		pitchCollection = new LinkedHashSet<E>();
	}

	@Override
	public Iterator<E> iterator() {
		return pitchCollection.iterator();
	}

}
