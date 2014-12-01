/**
 * 
 */
package twelve;

/**
 * A NamedNote represents a defined pitch. This class is immutable.
 * https://en.wikipedia.org/wiki/NamedNote#Note_designation_in_accordance_with_octave_name
 * @author Geoffrey
 */
public class NamedNote implements Note {
	/** The pitch class to which this note belongs. */
	private final PitchClass pitchClass;
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
	 * @param pc the PitchClass that this NamedNote belongs to. Must not be null.
	 * @param reg the register that this NamedNote belongs to. Must not be null
	 */
	public NamedNote(PitchClass pc) {
		this.pitchClass = pc;
		StringBuilder repBuilder = new StringBuilder();
		StringBuilder otherBuilder = new StringBuilder();
		switch(pc) {
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
	
	/**
	 * Creates a new NamedNote based on a String representation of the note
	 * @param note the String representing the NamedNote to be created. The format of the
	 *  Note should be as follows:
	 *  <ul>
	 *  	<li>First character: [A-G]</li>
	 *  	<li>Second character (optional): [#bx♯♭♮], or either of U+1D12B, U+1D12A</li>
	 *  </ul> 
	 * @throws IllegalArgumentException if the parameter is not of a valid format.
	 */
	public NamedNote(String note) throws IllegalArgumentException {
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
			default: throw new IllegalArgumentException("NamedNote name " + noteParse[1] + " is invalid. NamedNote names must be one of (A, B, C, D, E, F, or G).");
		}
		
		// parse the accidental
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
		
		stringRep = noteParse[0] + noteParse[1];
		otherStringRep = this.getEnharmonic(stringRep);
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
	 * Gets the PitchClass of this note
	 * @return the associated PitchClass
	 */
	@Override
	public PitchClass getPitchClass() {
		return pitchClass;
	}
	
	/**
	 * Get this note's enharmonic string representation. For example,
	 *  constructing a new NamedNote("C#"), then calling this method will return
	 *  "Db" because D-flat is enharmonic to C-sharp.
	 * @return
	 */
	public String getEnharmonic() {
		return otherStringRep;
	}
	
	/**
	 * Returns an enharmonic note string.
	 * @param note String representation of the NamedNote, e.g "G#"
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
		else { // NamedNote is something like "A", "B"
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
	 * Returns the NamedNote resulting from transposing this note by a certain interval.
	 * @param interval the interval to which to transpose the NamedNote
	 * @return a NamedNote representing the resultant transposition.
	 */
	@Override
	public NamedNote transpose(int interval) {
		// TODO: Implement
		return null;
	}
	
	/**
	 * Returns the intervallic distance between this note and otherNote,
	 *  relative to thisNote.
	 * @param otherNote
	 * @return
	 */
	@Override
	public int intervalTo(Note otherNote) {
		// TODO: Implement
		return 0;
	}
	
	/**
	 * Returns whether this note and another note are the same note.
	 * @param n the other note to which to compare
	 * @return true if the two notes have the same note, false otherwise
	 */
	@Override
	public boolean equals(Object n) {
		return this.pitchClass.degree() == ((NamedNote) n).pitchClass.degree();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.pitchClass.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return stringRep;
	}
}