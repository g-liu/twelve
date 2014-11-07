/**
 * 
 */
package twelve;

/**
 * A note.
 * @author Geoffrey Liu
 */
public interface Note {
	/**
	 * Gets the name of the note
	 * @return the note name
	 */
	public String getNoteName();
	
	/**
	 * Gets the PitchClass of this note
	 * @return the associated PitchClass
	 */
	public PitchClass getPitchClass();
	
	/**
	 * Get this note's enharmonic string representation. For example,
	 *  constructing a new NamedNote("C#"), then calling this method will return
	 *  "Db" because D-flat is enharmonic to C-sharp.
	 * @return
	 */
	public String getEnharmonic();
	
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
	public int intervalTo(NamedNote otherNote);

}
