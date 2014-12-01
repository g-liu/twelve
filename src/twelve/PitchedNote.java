/**
 * 
 */
package twelve;

/**
 * A Note with a PitchClass, but not a name.
 * @author Geoffrey Liu
 *
 */
public class PitchedNote implements Note {
	
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
