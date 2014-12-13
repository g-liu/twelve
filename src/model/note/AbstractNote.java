package model.note;

/**
 * @author Geoffrey Liu
 * @since 1.0
 */
public abstract class AbstractNote implements Note {

	/**
	 * @see model.note.Note#getPitchClass()
	 */
	@Override
	public abstract PitchClass getPitchClass();

	/**
	 * @see model.note.Note#transpose(int)
	 */
	@Override
	public abstract Note transpose(int interval);

	/**
	 * @see model.note.Note#intervalTo(model.note.Note)
	 */
	@Override
	public int intervalTo(Note otherNote) {
		return otherNote.getPitchClass().degree() - this.getPitchClass().degree();
	}

}
