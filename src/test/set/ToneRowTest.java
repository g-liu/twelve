/**
 * 
 */
package test.set;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.note.NamedNote;
import model.note.Note;
import model.set.ToneRow;

import org.junit.Test;

/**
 * @author Geoffrey
 *
 */
public class ToneRowTest {
	ToneRow<? extends Note> trn;
	
	@Test
	public void initializeToneRow() {
		List<NamedNote> notes = new ArrayList<NamedNote>();
		notes.add(new NamedNote("C"));
		notes.add(new NamedNote("C#"));
		notes.add(new NamedNote("D"));
		notes.add(new NamedNote("D#"));
		notes.add(new NamedNote("E"));
		notes.add(new NamedNote("F"));
		notes.add(new NamedNote("F#"));
		notes.add(new NamedNote("G"));
		notes.add(new NamedNote("G#"));
		notes.add(new NamedNote("A"));
		notes.add(new NamedNote("A#"));
		notes.add(new NamedNote("B"));
		trn = new ToneRow<NamedNote>(notes);
		
		assertNotNull(trn);
	}
	
}
