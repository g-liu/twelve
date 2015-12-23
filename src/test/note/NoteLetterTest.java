package test.note;

import static org.junit.Assert.*;
import model.note.NoteLetter;

import org.junit.Test;

public class NoteLetterTest {

	@Test
	public void assureAllCorrectEnumValues() {
		assertEquals("Note 'C' not represented correctly", "C", NoteLetter.C.name());
		assertEquals("Note 'D' not represented correctly", "D", NoteLetter.D.name());
		assertEquals("Note 'E' not represented correctly", "E", NoteLetter.E.name());
		assertEquals("Note 'F' not represented correctly", "F", NoteLetter.F.name());
		assertEquals("Note 'G' not represented correctly", "G", NoteLetter.G.name());
		assertEquals("Note 'A' not represented correctly", "A", NoteLetter.A.name());
		assertEquals("Note 'B' not represented correctly", "B", NoteLetter.B.name());
	}
	
	@Test
	public void nextNoteAfterA() {
		assertEquals("Next note is not 'B'", NoteLetter.B, NoteLetter.nextNote(NoteLetter.A));
	}
	
	@Test
	public void nextNoteAfterB() {
		assertEquals("Next note is not 'C'", NoteLetter.C, NoteLetter.nextNote(NoteLetter.B));
	}
	
	@Test
	public void nextNoteAfterC() {
		assertEquals("Next note is not 'D'", NoteLetter.D, NoteLetter.nextNote(NoteLetter.C));
	}
	
	@Test
	public void nextNoteAfterD() {
		assertEquals("Next note is not 'E'", NoteLetter.E, NoteLetter.nextNote(NoteLetter.D));
	}
	
	@Test
	public void nextNoteAfterE() {
		assertEquals("Next note is not 'F'", NoteLetter.F, NoteLetter.nextNote(NoteLetter.E));
	}
	
	@Test
	public void nextNoteAfterF() {
		assertEquals("Next note is not 'G'", NoteLetter.G, NoteLetter.nextNote(NoteLetter.F));
	}
	
	@Test
	public void nextNoteAfterG() {
		assertEquals("Next note is not 'A'", NoteLetter.A, NoteLetter.nextNote(NoteLetter.G));
	}
	
	@Test
	public void previousNoteBeforeA() {
		assertEquals("Previous note is not 'G'", NoteLetter.G, NoteLetter.previousNote(NoteLetter.A));
	}
	
	@Test
	public void previousNoteBeforeB() {
		assertEquals("Previous note is not 'A'", NoteLetter.A, NoteLetter.previousNote(NoteLetter.B));
	}
	
	@Test
	public void previousNoteBeforeC() {
		assertEquals("Previous note is not 'B'", NoteLetter.B, NoteLetter.previousNote(NoteLetter.C));
	}
	
	@Test
	public void previousNoteBeforeD() {
		assertEquals("Previous note is not 'C'", NoteLetter.C, NoteLetter.previousNote(NoteLetter.D));
	}
	
	@Test
	public void previousNoteBeforeE() {
		assertEquals("Previous note is not 'D'", NoteLetter.D, NoteLetter.previousNote(NoteLetter.E));
	}
	
	@Test
	public void previousNoteBeforeF() {
		assertEquals("Previous note is not 'E'", NoteLetter.E, NoteLetter.previousNote(NoteLetter.F));
	}
	
	@Test
	public void previousNoteBeforeG() {
		assertEquals("Previous note is not 'F'", NoteLetter.F, NoteLetter.previousNote(NoteLetter.G));
	}

}
