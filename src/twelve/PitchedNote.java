/**
 * 
 */
package twelve;

/**
 * A Note with a PitchClass, but not a name.
 * @author Geoffrey Liu
 */
public class PitchedNote extends AbstractNote {
	
	/** The pitch class of this note */
	private PitchClass pitchClass;
	
	/**
	 * Constructs a new instance of PitchedNote
	 * @param pitchClass the integer representing the desired PitchClass.
	 */
	public PitchedNote(int pitchClass) {
		if(pitchClass < 0 || pitchClass > 11) {
			throw new IllegalArgumentException("Error: pitch class must be between 0 and 11");
		}
		this.pitchClass = PitchClass.getPitchClass(pitchClass);
	}
	
	/**
	 * Constructs a new instance of PitchedNote. This method is provided, as some
	 *  musical sources specify 't' = 10, 'e' = 11, or A = 10, B = 11.
	 * @param note the character representing the PitchedNote. Must be one of: [teAB]
	 */
	public PitchedNote(char note) {
		switch(note) {
			case 'A':
			case 't': this.pitchClass = PitchClass.TEN;
			case 'B':
			case 'e': this.pitchClass = PitchClass.ELEVEN;
			default: throw new IllegalArgumentException("Invalid pitch class: " + note);
		}
	}

	/**
	 * Constructs a new instance of PitchedNote
	 * @param pc the PitchClass
	 */
	public PitchedNote(PitchClass pc) {
		this.pitchClass = pc;
	}
	
	/**
	 * Constructs a new instance of PitchedNote, given a NamedNote
	 * @param note the NamedNote
	 */
	public PitchedNote(NamedNote note) {
		this.pitchClass = note.getPitchClass();
	}

	/**
	 * @see twelve.Note#getPitchClass()
	 */
	@Override
	public PitchClass getPitchClass() {
		return pitchClass;
	}

	/**
	 * @see twelve.Note#transpose(int)
	 */
	@Override
	public Note transpose(int interval) {
		return new PitchedNote(this.pitchClass.degree() + interval);
	}

	@Override
	public int hashCode() {
		return this.pitchClass.hashCode();
	}
	
	@Override
	public String toString() {
		return pitchClass.toString();
	}
	
}
