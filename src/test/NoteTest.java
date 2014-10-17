/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import twelve.Note;
import twelve.PitchClass;

/**
 * @author Geoffrey
 *
 */
public class NoteTest {

	@Test
	public void testNoteNamesCorrespondToPitchClasses() {
		Note[] whiteKeys = new Note[]{
				new Note(PitchClass.ZERO,   3),
				new Note(PitchClass.TWO,    3),
				new Note(PitchClass.FOUR,   3),
				new Note(PitchClass.FIVE,   3),
				new Note(PitchClass.SEVEN,  3),
				new Note(PitchClass.NINE,   3),
				new Note(PitchClass.ELEVEN, 3),
		};
		String[] expNames = new String[]{
				"C3", "D3", "E3", "F3", "G3", "A3", "B3"
		};
		for(int i = 0; i < whiteKeys.length; i++) {
			assertEquals("Strings not equal!", whiteKeys[i].toString(), expNames[i]);
		}
	}

}
