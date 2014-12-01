/**
 * 
 */
package twelve;

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
	 * @return
	 */
	public int intervalTo(Note otherNote);

}
