/**
 * 
 */
package twelve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Geoffrey Liu
 *
 */
public final class NoteLetter {
	private static List<String> letterNames;
	
	private NoteLetter() {
		letterNames = new ArrayList<String>();
		letterNames.add("C");
		letterNames.add("D");
		letterNames.add("E");
		letterNames.add("F");
		letterNames.add("G");
		letterNames.add("A");	
		letterNames.add("B");
	}
	
	/**
	 * The next note letter after the current
	 * @param current the current note
	 * @return
	 */
	public static String nextNote(String current) {
		int currIndex = letterNames.indexOf(current);
		return letterNames.get((currIndex + 1) % letterNames.size());
	}
	
	/**
	 * The previous note letter before the current
	 * @param current the current note
	 * @return
	 */
	public static String previousNote(String current) {
		int currIndex = letterNames.indexOf(current);
		return letterNames.get((currIndex + 1) % letterNames.size());
	}
}
