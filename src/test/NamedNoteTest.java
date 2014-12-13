package test;

import static org.junit.Assert.*;

import org.junit.Test;

import twelve.NamedNote;
import twelve.PitchClass;

/**
 * @author Geoffrey Liu
 */
public class NamedNoteTest {
	
	@Test
	public void createNamedNoteFromWhiteKeys() {
		NamedNote c = new NamedNote("C");
		NamedNote d = new NamedNote("D");
		NamedNote e = new NamedNote("E");
		NamedNote f = new NamedNote("F");
		NamedNote g = new NamedNote("G");
		NamedNote a = new NamedNote("A");
		NamedNote b = new NamedNote("B");
		
		assertEquals("C", c.getNoteName());
		assertEquals("D", d.getNoteName());
		assertEquals("E", e.getNoteName());
		assertEquals("F", f.getNoteName());
		assertEquals("G", g.getNoteName());
		assertEquals("A", a.getNoteName());
		assertEquals("B", b.getNoteName());
	}
	
	@Test
	public void createNamedNoteFromBlackSharpKeys() {
		NamedNote cs = new NamedNote("C#");
		NamedNote ds = new NamedNote("D#");
		NamedNote fs = new NamedNote("F#");
		NamedNote gs = new NamedNote("G#");
		NamedNote as = new NamedNote("A#");
		
		assertEquals("C#", cs.getNoteName());
		assertEquals("D#", ds.getNoteName());
		assertEquals("F#", fs.getNoteName());
		assertEquals("G#", gs.getNoteName());
		assertEquals("A#", as.getNoteName());
	}
	
	@Test
	public void createNamedNoteFromBlackFlatKeys() {
		NamedNote df = new NamedNote("Db");
		NamedNote ef = new NamedNote("Eb");
		NamedNote gf = new NamedNote("Gb");
		NamedNote af = new NamedNote("Ab");
		NamedNote bf = new NamedNote("Bb");
		
		assertEquals("Db", df.getNoteName());
		assertEquals("Eb", ef.getNoteName());
		assertEquals("Gb", gf.getNoteName());
		assertEquals("Ab", af.getNoteName());
		assertEquals("Bb", bf.getNoteName());
	}
	
	@Test
	public void createNamedNoteFromIrregularAccidentals() {
		NamedNote cb = new NamedNote("Cb");
		NamedNote fb = new NamedNote("Fb");
		NamedNote es = new NamedNote("E#");
		NamedNote bs = new NamedNote("B#");
		
		assertNotNull(cb);
		assertNotNull(fb);
		assertNotNull(es);
		assertNotNull(bs);
		
		assertEquals("B", cb.getNoteName());
		assertEquals("C", bs.getNoteName());
		assertEquals("F", es.getNoteName());
		assertEquals("E", fb.getNoteName());
	}
	
	@Test
	public void createNamedNoteFromDoubleHash() {
		NamedNote cds = new NamedNote("C##");
		NamedNote dds = new NamedNote("D##");
		NamedNote eds = new NamedNote("E##");
		NamedNote fds = new NamedNote("F##");
		NamedNote gds = new NamedNote("G##");
		NamedNote ads = new NamedNote("A##");
		NamedNote bds = new NamedNote("B##");
		
		assertEquals("D", cds.getNoteName());
		assertEquals("E", dds.getNoteName());
		assertEquals("F#", eds.getNoteName());
		assertEquals("G", fds.getNoteName());
		assertEquals("A", gds.getNoteName());
		assertEquals("B", ads.getNoteName());
		assertEquals("C#", bds.getNoteName());
	}
	
	@Test
	public void createNamedNoteFromDoubleB() {
		NamedNote cdb = new NamedNote("Cbb");
		NamedNote ddb = new NamedNote("Dbb");
		NamedNote edb = new NamedNote("Ebb");
		NamedNote fdb = new NamedNote("Fbb");
		NamedNote gdb = new NamedNote("Gbb");
		NamedNote adb = new NamedNote("Abb");
		NamedNote bdb = new NamedNote("Bbb");
	
		assertEquals("Bb", cdb.getNoteName());
		assertEquals("C", ddb.getNoteName());
		assertEquals("D", edb.getNoteName());
		assertEquals("Eb", fdb.getNoteName());
		assertEquals("F", gdb.getNoteName());
		assertEquals("G", adb.getNoteName());
		assertEquals("A", bdb.getNoteName());
	}
	
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
