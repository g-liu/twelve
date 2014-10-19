/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import twelve.Note;
import twelve.PitchClass;
import twelve.ToneRow;

/**
 * @author Geoffrey
 *
 */
public class ToneRowTest {

	@Test
	public void cannotInsertDuplicateNotes() {
		// these notes are an octave apart
		Note n1 = new Note(PitchClass.ZERO, 4);
		Note n2 = new Note(PitchClass.ZERO, 5);
		
		ToneRow tr = new ToneRow();
		tr.add(n1);
		tr.add(n2);
		
		assertEquals("Should only be one element", tr.size(), 1);
	}
	
	@Test
	public void canInsertNonDuplicateNotes() {
		// these notes are not of the same pitch class
		Note n1 = new Note(PitchClass.FIVE, 3);
		Note n2 = new Note(PitchClass.EIGHT, 3);
		
		ToneRow tr = new ToneRow();
		tr.add(n1);
		tr.add(n2);
		
		assertEquals("Should have two elements", tr.size(), 2);
	}

}
