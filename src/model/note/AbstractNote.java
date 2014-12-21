package model.note;

/**
 * An abstract implementation of the Note interface. Introduces operations
 * common to every AbstractNote subclass.
 * 
 * @author Geoffrey Liu
 * 
 * @since 1.0
 */
public abstract class AbstractNote implements Note {

	/**
	 * @see model.note.Note#getPitchClass()
	 */
	@Override
	public abstract PitchClass getPitchClass();

	/**
	 * @see model.note.Note#transpose(int)
	 */
	@Override
	public abstract Note transpose(int interval);

	/**
	 * @see model.note.Note#intervalTo(model.note.Note)
	 */
	@Override
	public int intervalTo(Note otherNote) {
		return otherNote.getPitchClass().degree()
				- this.getPitchClass().degree();
	}

	/**
	 * Returns whether this note and another note are the same note.
	 * 
	 * @param n
	 *            the other note to which to compare
	 * @return true if the two notes have the same note, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Note)) {
			return false;
		}
		Note no = (Note) o;
		return this.getPitchClass().equals(no.getPitchClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return getPitchClass().hashCode();
	}

}
