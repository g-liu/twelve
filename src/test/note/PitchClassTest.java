package test.note;

import static org.junit.Assert.*;
import model.note.PitchClass;

import org.junit.Test;

/**
 * @author Geoffrey Liu *
 */
public class PitchClassTest {	
	
	@Test
	public void basicTransposition() {
		PitchClass tp = (PitchClass.ZERO).getTransposition(1);
		assertEquals(PitchClass.ONE, tp);
	}
	
	@Test
	public void noTransposition() {
		PitchClass tp = (PitchClass.SIX).getTransposition(0);
		assertEquals(PitchClass.SIX, tp);
	}
	
	@Test
	public void transpositionWrapAroundFalling() {
		PitchClass tp = (PitchClass.ELEVEN).getTransposition(1);
		assertEquals(PitchClass.ZERO, tp);
	}
	
	@Test
	public void transpositionWrapAroundRising() {
		PitchClass tp = (PitchClass.ZERO).getTransposition(-1);
		assertEquals(PitchClass.ELEVEN, tp);
	}

}
