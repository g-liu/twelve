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
	public void testWhiteNotesCorrespondToPitchClasses() {
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
			assertEquals("Strings not equal!", expNames[i], whiteKeys[i].toString());
		}
	}
	
	@Test
	public void testBlackNotesCorrespondToPitchClasses() {
		Note[] blackKeys = new Note[]{
				new Note(PitchClass.ONE,   3),
				new Note(PitchClass.THREE, 3),
				new Note(PitchClass.SIX,   3),
				new Note(PitchClass.EIGHT, 3),
				new Note(PitchClass.TEN,   3),
		};
		String[] expNames = new String[]{
				"C#3", "D#3", "F#3", "G#3", "A#3"
		};
		for(int i = 0; i < blackKeys.length; i++) {
			assertEquals("Strings not equal!", expNames[i], blackKeys[i].toString());
		}
	}
	
	@Test
	public void testNotesHaveCorrectEnharmonicEquivalents() {
		Note[] enharmonic = new Note[]{
				new Note(PitchClass.ZERO,   3), // C
				new Note(PitchClass.ONE,    3), // C#
				new Note(PitchClass.THREE,  3), // D#
				new Note(PitchClass.FOUR,   3), // E
				new Note(PitchClass.FIVE,   3), // F
				new Note(PitchClass.SIX,    3), // F#
				new Note(PitchClass.EIGHT,  3), // G#
				new Note(PitchClass.TEN,    3), // A#
				new Note(PitchClass.ELEVEN, 3), // B
		};
		String[] expNames = new String[]{
				"B#", "Db", "Eb", "Fb", "E#",
				"Gb", "Ab", "Bb", "Cb",
		};
		for(int i = 0; i < enharmonic.length; i++) {
			assertEquals("Strings not equal!", expNames[i], enharmonic[i].getEnharmonic());
		}
	}
	
	@Test
	public void testNotesWithoutEnharmonicEquivalentsReturnThemselves() {
		Note[] nonEnharmonic = new Note[]{
				new Note(PitchClass.TWO,   3), // D
				new Note(PitchClass.SEVEN, 3), // G
				new Note(PitchClass.NINE,  3), // A
		};
		for(int i = 0; i < nonEnharmonic.length; i++) {
			assertEquals("Strings not equal!", nonEnharmonic[i].getNoteName(), nonEnharmonic[i].getEnharmonic());
		}
	}
	
	@Test
	public void testNotesInCorrectRegister() {
		Note[] registers = new Note[]{
				new Note(PitchClass.EIGHT, -1),
				new Note(PitchClass.EIGHT, 2),
				new Note(PitchClass.EIGHT, 3),
				new Note(PitchClass.EIGHT, 6),
				new Note(PitchClass.EIGHT, 9),
		};
		String[] expNames = new String[]{
				"G#-1", "G#2", "G#3", "G#6", "G#9"
		};
		for(int i = 0; i < registers.length; i++) {
			assertEquals("Strings not equal!", expNames[i], registers[i].toString());
		}
	}

}
