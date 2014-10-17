/**
 * 
 */
package twelve;

/**
 * An enum representing a certain pitch class.
 * Pitch classes are away to group pitches by name, by assigning an integer.
 * The system works like such:
 * 0  => C
 * 1  => C#/Db (note: these are enharmonic).
 * 2  => D
 * ...
 * 11 => B
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
	
	int degree;
	
	PitchClass(int degree) {
		this.degree = degree;
	}
}

