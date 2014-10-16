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
		Note n1 = new Note(new PitchClass(1), 4);
		Note n2 = new Note(new PitchClass(1), 5);
		
		ToneRow tr = new ToneRow();
		tr.add(n1);
		tr.add(n2);
		
		assertEquals(tr.size(), 1);
	}

}
