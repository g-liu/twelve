package twelve;

/**
 * An immutable class that represents a single pitch class.
 * Pitch class is defined numerically:
 * 0 = C, 1 = C-sharp, ... 11 = B
 * @author Geoffrey Liu
 *
 */
public class PitchClass {
	private final int degree;
	
	public PitchClass(int degree) {
		this.degree = degree;
	}
	
	public PitchClass(String note) {
		// TODO: Implement
		String[] tokens = note.split("");
		int roughDegree = -1;
		switch(tokens[0].toUpperCase()) {
			case "A": roughDegree = 9;  break;
			case "B": roughDegree = 11; break;
			case "C": roughDegree = 0;  break;
			case "D": roughDegree = 2;  break;
			case "E": roughDegree = 4;  break;
			case "F": roughDegree = 5;  break;
			case "G": roughDegree = 7;  break;
		}
		
		// handle accidentals
		if(tokens.length == 2) {
			if(tokens[1].equals("#") || tokens[1].equals("♯")) {
				roughDegree++;
			}
			else if(tokens[1].equals("b") || tokens[1].equals("♭")) {
				roughDegree--;
			}
			else if(tokens[1].equals("𝄫")) {
				roughDegree -= 2;
			}
			else if(tokens[1].equals("𝄪")) {
				roughDegree += 2;
			}
		}
		
		degree = roughDegree % 12;
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
