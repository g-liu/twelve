/**
 * 
 */
package twelve;

/**
 * An enum representing a certain pitch class.
 * Pitch classes are away to group pitches by name, by assigning an integer.
 * The system works like such:
 * 	0  => C
 * 	1  => C#/Db (note: these are enharmonic).
 * 	2  => D
 * 	...
 * 	11 => B
 * Note that PitchClasses do not have a name. This is because in music set theory,
 *  enharmonic pitches are considered the same. Pitch classes are also independent
 *  of register.
 * @author sn310533
 *
 */
public enum PitchClass {
	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	ELEVEN(11);
	
	private final int degree;
	
	private PitchClass(int degree) {
		this.degree = degree;
	}
	
	/**
	 * Get the degree of the PitchClass
	 * @return the degree of the PitchClass
	 */
	public int degree() {
		return degree;
	}
	
	/**
	 * Returns the PitchClass that matches with the given integer
	 * @param degree the numerical pitch class
	 * @return the associated PitchClass, or null if there is no such.
	 */
	public static PitchClass getPitchClass(int degree) {
		for(PitchClass pc : PitchClass.values()) {
			if(pc.degree() == degree) { return pc; }
		}
		return null; // no matching PitchClass
	}
	
	/**
	 * Returns the resultant PitchClass given a transposition by a given number
	 *  of semitones.
	 * @param interval the number of semitones to transpose.
	 *  If positive, transposes "up"
	 *  If negative, transposes "down"
	 * @return 
	 */
	public PitchClass getTransposition(int interval) {
		int numberClass = (degree + interval) % 12;
		return getPitchClass(numberClass);
	}
}

