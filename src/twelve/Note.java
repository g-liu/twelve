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
	/** The pitch class to which this note belongs. */
	private final PitchClass pitchClass;
	/**
	 * The register in which this Note belongs. register is set according to the
	 *  scientific pitch notation standard, which assigns middle C to 4.
	 *  https://en.wikipedia.org/wiki/Scientific_pitch_notation
	 */
	private final int register;
	/**
	 * A string representation of the note. Needed, as some notes share the same
	 *  pitch class and register, e.g. C# and Db.
	 */
	private final String stringRep;
	/**
	 * If the note can be represented differently, say so.
	 */
	private final String otherStringRep;
	
	/**
	 * Constructs a new Node belonging to the specified PitchClass and having the
	 *  specified register.
	 * @param pc the PitchClass that this Note belongs to. Must not be null.
	 * @param reg the register that this Note belongs to. Must not be null
	 */
	public Note(PitchClass pc, int reg) {
		// TODO: Implement
		this.pitchClass = pc;
		this.register = reg;
		StringBuilder repBuilder = new StringBuilder();
		StringBuilder otherBuilder = new StringBuilder();
		switch(pc) {
		// TODO: Build the string representation
		case ONE:
			repBuilder.append("#");
			otherBuilder.append("Db");
		case ZERO:
			repBuilder.insert(0, "C");
			if(otherBuilder.length() == 0) {
				otherBuilder.append("B#");
			}
			break;
		case THREE:
			repBuilder.append("#");
			otherBuilder.append("Eb");
		case TWO:
			repBuilder.insert(0, "D");
			break;
		case FOUR:
			repBuilder.append("E");
			otherBuilder.append("Fb");
			break;
		case SIX:
			repBuilder.append("#");
			otherBuilder.append("Gb");
		case FIVE:
			repBuilder.insert(0, "F");
			if(otherBuilder.length() == 0) {
				otherBuilder.append("E#");
			}
			break;
		case EIGHT:
			repBuilder.append("#");
			otherBuilder.append("Ab");
		case SEVEN:
			repBuilder.insert(0, "G");
			break;
		case TEN:
			repBuilder.append("#");
			otherBuilder.append("Bb");
		case NINE:
			repBuilder.insert(0, "A");
			break;
		case ELEVEN:
			repBuilder.append("B");
			otherBuilder.append("Cb");
		default:
			break;
		}
		
		stringRep = repBuilder.toString();
		otherStringRep = otherBuilder.length() > 0 ? otherBuilder.toString() : stringRep;
	}
	
	// TODO: Specify format in @param
	/**
	 * Creates a new Note based on a String representation of the note
	 * @param note the String representing the Note to be created.
	 * @throws IllegalArgumentException if the parameter is not of a valid format.
	 */
	public Note(String note) throws IllegalArgumentException {
		String[] noteParse = note.split("", 3);
		// check the representation. noteParse[0] should contain the note name from A-G,
		// noteParse[1], if it exists, should contain one of eight modifiers:
		// b or ♭ (flat)
		// # or ♯ (sharp)
		// ♮ (natural)
		// U+1D12B (double flat)
		// x or U+1D12A (double sharp)
		// in the case of the latter two, this constructor will normalize the
		// note name as to not use double-flat or double-sharp. For example,
		// A-double-sharp will be normalized to B.
		if(noteParse.length == 0) {
			throw new IllegalArgumentException("The note name " + note + " is invalid.");
		}
		noteParse[0] = noteParse[0].toUpperCase();
		
		int pitchClassNum = 0;
		
		switch(noteParse[0]) {
		case "A": pitchClassNum = 9; break;
		case "B": pitchClassNum = 11; break;
		case "C": pitchClassNum = 0; break;
		case "D": pitchClassNum = 2; break;
		case "E": pitchClassNum = 4; break;
		case "F": pitchClassNum = 5; break;
		case "G": pitchClassNum = 7; break;
		default: throw new IllegalArgumentException("Note name " + noteParse[1] + " is invalid. Note names must be one of (A, B, C, D, E, F, or G).");
		}
		
		if(noteParse.length > 1) {
			switch(noteParse[1]) {
			case "#":
			case "♯": pitchClassNum++; break;
			case "b": 
			case "♭": pitchClassNum--; break;
			case "x": 
			case "𝄪": pitchClassNum += 2; break; // double sharp
			case "𝄫": pitchClassNum -= 2; break; // double flat
			default: throw new IllegalArgumentException("Invalid note modifier " + noteParse[1]);
			}
		}
		
		// TODO: noteParse[2] is the register
		int tempRegister = 4;
		if(noteParse.length > 2) {
			tempRegister = Integer.parseInt(noteParse[2]);
		}
		
		stringRep = noteParse[0] + noteParse[1];
		otherStringRep = this.getEnharmonic(stringRep);
		register = tempRegister;
		pitchClass = PitchClass.getPitchClass(pitchClassNum % 12);
	}
	
	/**
	 * Gets the name of the note
	 * @return the note name
	 */
	public String getNoteName() {
		return stringRep;
	}
	
	/**
	 * Gets the octave register of this Note
	 * @return the register in which this note belongs
	 */
	public int getRegister() {
		return register;
	}
	
	/**
	 * Gets the PitchClass of this note
	 * @return the associated PitchClass
	 */
	public PitchClass getPitchClass() {
		return pitchClass;
	}
	
	/**
	 * Get this note's enharmonic string representation. For example,
	 *  constructing a new Note("C#"), then calling this method will return
	 *  "Db" because D-flat is enharmonic to C-sharp.
	 * @return
	 */
	public String getEnharmonic() {
		return otherStringRep;
	}
	
	/**
	 * Returns an enharmonic note string.
	 * @param note String representation of the Note, e.g "G#"
	 * @return
	 */
	private String getEnharmonic(String note) {
		String[] noteTokens = note.split("");
		StringBuilder enh = new StringBuilder();
		if(noteTokens.length > 1) {
			switch(noteTokens[1]) {
			case "#":
			case "♯": enh.append(NoteLetter.nextNote(noteTokens[0]));
				switch(noteTokens[0].toUpperCase()) { // may have to add flats
				case "C": case "D": case "F": case "G": case "A":
					enh.append("b");
					break;
				}
			case "b": 
			case "♭": enh.append(NoteLetter.previousNote(noteTokens[0]));
				switch(noteTokens[0].toUpperCase()) {
				case "D": case "E": case "G": case "A": case "B":
					enh.append("#");
					break;
				}
			case "x": 
			case "𝄪": enh.append(NoteLetter.nextNote(noteTokens[0])); // double sharp
				switch(noteTokens[0].toUpperCase()) { // may have to add sharps
				case "E": case "B":
					enh.append("#");
					break;
				}
			case "𝄫": enh.append(NoteLetter.previousNote(noteTokens[0])); // double flat
				switch(noteTokens[0].toUpperCase()) { // may have to add flats
				case "C": case "F":
					enh.append("b");
					break;
				}
			}
		}
		else { // Note is something like "A", "B"
			switch(noteTokens[0].toUpperCase()) {
			case "B": enh.append("Cb"); break;
			case "E": enh.append("Fb"); break;
			case "C": enh.append("B#"); break;
			case "F": enh.append("E#"); break;
			default: enh.append(noteTokens[0]); break;
			}
		}
		
		return enh.toString();
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
		// TODO: Implement
		return 0;
	}
	
	/**
	 * Returns the MIDI specified number that represents the Note.
	 *  If none, returns -1.
	 * @return MIDI equivalent number for the note, -1 if not applicable.
	 */
	public int getMidiNumber() {
		int midi = register + 1 + pitchClass.degree();
		if(midi < 0 || midi > 127) {
			return -1;
		}
		return midi;
	}
	
	/**
	 * Returns whether this note and another note are the same note.
	 * @param n the other note to which to compare
	 * @return true if the two notes have the same note, false otherwise
	 */
	@Override
	public boolean equals(Object n) {
		return this.pitchClass.degree() == ((Note) n).pitchClass.degree();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.pitchClass.degree() * 37 - (this.pitchClass.degree() - 5) * 31;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return stringRep + register;
	}
}