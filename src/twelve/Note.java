/**
 * 
 */
package twelve;

/**
 * A Note represents a defined pitch. This class is immutable.
 * https://en.wikipedia.org/wiki/Note#Note_designation_in_accordance_with_octave_name
 * @author Geoffrey
 */
public class Note {
	/**
	 * The pitch class to which this note belongs.
	 * https://en.wikipedia.org/wiki/Pitch_class
	 */
	private final PitchClass pitchClass;
	/**
	 * The register in which this Note belongs. register is set according to the
	 *  scientific pitch notation standard, which assigns middle C to 4.
	 *  https://en.wikipedia.org/wiki/Scientific_pitch_notation
	 */
	private final int register;
	
	public Note(PitchClass pc, int reg) {
		this.pitchClass = pc;
		this.register = reg;
	}
	
	public PitchClass getPitchClass() {
		return pitchClass;
	}
	
	/**
	 * Returns the Note resulting from transposing this note by a certain interval.
	 * @param interval the interval to which to transpose the Note
	 * @return a Note representing the resultant transposition.
	 */
	public Note transpose(int interval) {
		// TODO: Implement
		return null;
	}
	
	/**
	 * Returns the intervallic distance between this note and otherNote,
	 *  relative to thisNote.
	 * @param otherNote
	 * @return
	 */
	public int intervalTo(Note otherNote) {
		return 0;
	}
	
	/**
	 * Returns the MIDI specified number that represents the Note.
	 *  If none, returns -1.
	 * @return MIDI equivalent number for the note, -1 if not applicable.
	 */
	public int getMidiNumber() {
		// TODO: Implement
		return 0;
	}
	
	/**
	 * Returns whether this note and another note have the same pitch class.
	 *  If they do, they are considered equal.
	 * @param n the other note to which to compare
	 * @return true if the two notes have the same pitch class, false otherwise
	 */
	public boolean equals(Note n) {
		return this.getPitchClass().equals(n.getPitchClass());
	}
	
	public boolean deepEquals(Note n) {
		return equals(n) && this.register == n.register;
	}

	@Override
	public String toString() {
		// TODO: Implement
		return pitchClass.toString() + register;
	}

}
