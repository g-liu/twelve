/**
 * 
 */
package twelve;

/**
 * A Note with a PitchClass, but not a name.
 * @author Geoffrey Liu
 *
 */
public class PitchedNote extends AbstractNote {
	
	/** The pitch class of this note */
	PitchClass pc;
	
	/**
	 * Constructs a new instance of PitchedNote
	 * @param pitchClass the integer representing the desired PitchClass.
	 */
	public PitchedNote(int pitchClass) {
		if(pitchClass < 0 || pitchClass > 11) {
			throw new IllegalArgumentException("Error: pitch class must be between 0 and 11");
		}
		this.pc = PitchClass.getPitchClass(pitchClass);
	}
	
	/**
	 * Constructs a new instance of PitchedNote. This method is provided, as some
	 *  musical sources specify 't' = 10, 'e' = 11, or A = 10, B = 11.
	 * @param note the character representing the PitchedNote. Must be one of: [teAB]
	 */
	public PitchedNote(char note) {
		switch(note) {
			case 'A':
			case 't': this.pc = PitchClass.TEN;
			case 'B':
			case 'e': this.pc = PitchClass.ELEVEN;
			default: throw new IllegalArgumentException("Invalid pitch class: " + note);
		}
	}

	/**
	 * Constructs a new instance of PitchedNote
	 * @param pc the PitchClass
	 */
	public PitchedNote(PitchClass pc) {
		this.pc = pc;
	}
	
	/**
	 * Constructs a new instance of PitchedNote, given a NamedNote
	 * @param note the NamedNote
	 */
	public PitchedNote(NamedNote note) {
		this.pc = note.getPitchClass();
	}

	/* (non-Javadoc)
	 * @see twelve.Note#getPitchClass()
	 */
	@Override
	public PitchClass getPitchClass() {
		return pc;
	}

	/* (non-Javadoc)
	 * @see twelve.Note#transpose(int)
	 */
	@Override
	public Note transpose(int interval) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see twelve.Note#intervalTo(twelve.NamedNote)
	 */
	@Override
	public int intervalTo(Note otherNote) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return pc.toString();
	}
}
