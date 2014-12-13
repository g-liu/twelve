package model.note;

/**
 * A generic note.
 * @author Geoffrey Liu
 */
public interface Note {

	/**
	 * Gets the PitchClass of this note
	 * @return the associated PitchClass
	 */
	public PitchClass getPitchClass();
	
	/**
	 * Returns the NamedNote resulting from transposing this note by a certain interval.
	 * @param interval the interval to which to transpose the NamedNote
	 * @return a NamedNote representing the resultant transposition.
	 */
	public Note transpose(int interval);
	
	/**
	 * Returns the intervallic distance between this note and otherNote,
	 *  relative to thisNote.
	 * @param otherNote
	 * @return the number of half steps from this note to the other note. It is guaranteed
	 *  that this value is in the range [-11, 11].
	 */
	public int intervalTo(Note otherNote);

}
