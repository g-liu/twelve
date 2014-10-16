/**
 * 
 */
package twelve;

/**
 * A Note represents a defined pitch. This class is immutable.
 * @author Geoffrey
 *
 */
public class Note {
	private final PitchClass pitchClass;
	private final int octave;
	
	public Note(PitchClass pc, int octv) {
		this.pitchClass = pc;
		this.octave = octv;
	}
	
	public Note transpose(Interval interval) {
		// TODO: Implement
		return null;
	}
	
	@Override
	public String toString() {
		// TODO: Implement
		return null;
	}
	
	@Override
	public int hashCode() {
		// TODO: Implement
		return 0;
	}

}
