package test.note;

import static org.junit.Assert.*;
import model.note.PitchClass;
import model.note.PitchedNote;

import org.junit.Test;

public class PitchedNoteTest {

	@Test
	public void properInitializationOfPitchedNoteWhite() {
		PitchedNote c = new PitchedNote(0);
		PitchedNote d = new PitchedNote(2);
		PitchedNote e = new PitchedNote(4);
		PitchedNote f = new PitchedNote(5);
		PitchedNote g = new PitchedNote(7);
		PitchedNote a = new PitchedNote(9);
		PitchedNote b = new PitchedNote(11);
		
		assertEquals(PitchClass.ZERO, c.getPitchClass());
		assertEquals(PitchClass.TWO, d.getPitchClass());
		assertEquals(PitchClass.FOUR, e.getPitchClass());
		assertEquals(PitchClass.FIVE, f.getPitchClass());
		assertEquals(PitchClass.SEVEN, g.getPitchClass());
		assertEquals(PitchClass.NINE, a.getPitchClass());
		assertEquals(PitchClass.ELEVEN, b.getPitchClass());
	}
	
	@Test
	public void properInitializationOfPitchedNoteBlack() {
		PitchedNote cs = new PitchedNote(1);
		PitchedNote ds = new PitchedNote(3);
		PitchedNote fs = new PitchedNote(6);
		PitchedNote gs = new PitchedNote(8);
		PitchedNote as = new PitchedNote(10);
		
		assertEquals(PitchClass.ONE, cs.getPitchClass());
		assertEquals(PitchClass.THREE, ds.getPitchClass());
		assertEquals(PitchClass.SIX, fs.getPitchClass());
		assertEquals(PitchClass.EIGHT, gs.getPitchClass());
		assertEquals(PitchClass.TEN, as.getPitchClass());
	}
	
	@Test
	public void properInitializationOfPitchedNoteLetterNames() {
		PitchedNote t = new PitchedNote('t');
		PitchedNote e = new PitchedNote('e');
		PitchedNote a = new PitchedNote('A');
		PitchedNote b = new PitchedNote('B');
		
		assertEquals(PitchClass.TEN, t.getPitchClass());
		assertEquals(PitchClass.ELEVEN, e.getPitchClass());
		assertEquals(PitchClass.TEN, a.getPitchClass());
		assertEquals(PitchClass.ELEVEN, b.getPitchClass());
	}

}
