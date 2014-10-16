package twelve;

/**
 * An immutable class that represents a single pitch class.
 * Pitch class is defined numerically:
 * 0 = C, 1 = C-sharp, ... 11 = B
 * @author Geoffrey Liu
 *
 */
public class PitchClass {
	private int degree;
	
	public PitchClass(int degree) {
		this.degree = degree;
	}
	
	public PitchClass(String note) {
		// TODO: Implement
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
}
