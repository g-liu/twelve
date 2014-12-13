package model.note;

/**
 * @author Geoffrey Liu
 *
 */
public enum NoteLetter {
	C('C'),
	D('D'),
	E('E'),
	F('F'),
	G('G'),
	A('A'),
	B('B');
	
	/** Representation of the note letter */
	@SuppressWarnings("unused")
	private final char LETTER;
	
	/**
	 * Creates a new NoteLetter. Solely for internal use.
	 * @param letter the character representing the note letter
	 */
	private NoteLetter(char letter) {
		this.LETTER = letter;
	}
	
	/**
	 * @see {@link #nextNote(NoteLetter)}
	 * @throws IllegalArgumentException if the specified enum type has no constant with the specified name, or the specified class object does not represent an enum type
	 * @throws NullPointerException if enumType or name is null
	 */
	public static NoteLetter nextNote(String current) {
		return nextNote(NoteLetter.valueOf(current));
	}
	
	/**
	 * The next note letter after the current
	 * @param current the current note
	 * @return the NoteLetter enum representing the note letter that succeeds the current note letter
	 */
	public static NoteLetter nextNote(NoteLetter current) {
		return NoteLetter.values()[(current.ordinal() + 1) % NoteLetter.values().length];
	}
	
	/**
	 * @see {@link #previousNote(NoteLetter)}
	 * @throws IllegalArgumentException if the specified enum type has no constant with the specified name, or the specified class object does not represent an enum type
	 * @throws NullPointerException if enumType or name is null
	 */
	public static NoteLetter previousNote(String current) {
		return previousNote(NoteLetter.valueOf(current));
	}
	
	/**
	 * The previous note letter before the current
	 * @param current the current note
	 * @return the NoteLetter enum representing the note letter that precedes the current note letter
	 */
	public static NoteLetter previousNote(NoteLetter current) {
		return NoteLetter.values()[(current.ordinal() + NoteLetter.values().length - 1) % NoteLetter.values().length];
	}
}
