/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import twelve.NamedNote;
import twelve.PitchClass;

/**
 * @author Geoffrey
 *
 */
public class NamedNoteTest {

	@Test
	public void testWhiteNotesCorrespondToPitchClasses() {
		NamedNote[] whiteKeys = new NamedNote[]{
				new NamedNote(PitchClass.ZERO),
				new NamedNote(PitchClass.TWO),
				new NamedNote(PitchClass.FOUR),
				new NamedNote(PitchClass.FIVE),
				new NamedNote(PitchClass.SEVEN),
				new NamedNote(PitchClass.NINE),
				new NamedNote(PitchClass.ELEVEN),
		};
		String[] expNames = new String[]{
				"C", "D", "E", "F", "G", "A", "B"
		};
		for(int i = 0; i < whiteKeys.length; i++) {
			assertEquals("Strings not equal!", expNames[i], whiteKeys[i].toString());
		}
	}
	
	@Test
	public void testBlackNotesCorrespondToPitchClasses() {
		NamedNote[] blackKeys = new NamedNote[]{
				new NamedNote(PitchClass.ONE),
				new NamedNote(PitchClass.THREE),
				new NamedNote(PitchClass.SIX),
				new NamedNote(PitchClass.EIGHT),
				new NamedNote(PitchClass.TEN),
		};
		String[] expNames = new String[]{
				"C#", "D#", "F#", "G#", "A#"
		};
		for(int i = 0; i < blackKeys.length; i++) {
			assertEquals("Strings not equal!", expNames[i], blackKeys[i].toString());
		}
	}
	
	@Test
	public void testNotesHaveCorrectEnharmonicEquivalents() {
		NamedNote[] enharmonic = new NamedNote[]{
				new NamedNote(PitchClass.ZERO), // C
				new NamedNote(PitchClass.ONE), // C#
				new NamedNote(PitchClass.THREE), // D#
				new NamedNote(PitchClass.FOUR), // E
				new NamedNote(PitchClass.FIVE), // F
				new NamedNote(PitchClass.SIX), // F#
				new NamedNote(PitchClass.EIGHT), // G#
				new NamedNote(PitchClass.TEN), // A#
				new NamedNote(PitchClass.ELEVEN), // B
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
		NamedNote[] nonEnharmonic = new NamedNote[]{
				new NamedNote(PitchClass.TWO), // D
				new NamedNote(PitchClass.SEVEN), // G
				new NamedNote(PitchClass.NINE), // A
		};
		for(int i = 0; i < nonEnharmonic.length; i++) {
			assertEquals("Strings not equal!", nonEnharmonic[i].getNoteName(), nonEnharmonic[i].getEnharmonic());
		}
	}

}
