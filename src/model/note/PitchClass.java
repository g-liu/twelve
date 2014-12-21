package model.note;

/**
 * An enum representing a certain pitch class. Pitch classes are away to group
 * pitches by name, by assigning an integer. The system works like such: 0 => C
 * 1 => C#/Db, 2 => D ... 11 => B NamedNote that PitchClasses do not have a
 * name. This is because in music set theory, enharmonic pitches are considered
 * equivalent. Pitch classes are also independent of register.
 * 
 * @author Geoffrey Liu
 *
 */
public enum PitchClass {
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(
			8), NINE(9), TEN(10), ELEVEN(11);

	/** The degree of the PitchClass. Degree 0 = C, Degree 1 = C#, and so on */
	private final int degree;

	/**
	 * Construct a new PitchClass
	 * 
	 * @param degree
	 *            the degree number
	 */
	private PitchClass(int degree) {
		this.degree = degree;
	}

	/**
	 * Get the degree of the PitchClass
	 * 
	 * @return the degree of the PitchClass
	 */
	public int degree() {
		return degree;
	}

	/**
	 * Returns the PitchClass that matches with the given integer
	 * 
	 * @param degree
	 *            the numerical pitch class
	 * @return the associated PitchClass, or null if there is no such.
	 */
	public static PitchClass getPitchClass(int degree) {
		for (PitchClass pc : PitchClass.values()) {
			if (pc.degree() == degree) {
				return pc;
			}
		}
		return null; // no matching PitchClass
	}

	/**
	 * Returns the resultant PitchClass given a transposition by a given number
	 * of semitones.
	 * 
	 * @param interval
	 *            the number of semitones to transpose. If positive, transposes
	 *            "up" If negative, transposes "down"
	 * @return the PitchClass that results from the transposition
	 */
	public PitchClass getTransposition(int interval) {
		interval %= 12;
		int numberClass = (12 + degree + interval) % 12;
		return getPitchClass(numberClass);
	}
}
