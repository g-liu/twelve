package model;

/**
 * @author Geoffrey Liu
 * @since 1.0
 */
public abstract class AbstractNote implements Note {

	/**
	 * @see model.Note#getPitchClass()
	 */
	@Override
	public abstract PitchClass getPitchClass();

	/**
	 * @see model.Note#transpose(int)
	 */
	@Override
	public abstract Note transpose(int interval);

	/**
	 * @see model.Note#intervalTo(model.Note)
	 */
	@Override
	public int intervalTo(Note otherNote) {
		return otherNote.getPitchClass().degree() - this.getPitchClass().degree();
	}

}
