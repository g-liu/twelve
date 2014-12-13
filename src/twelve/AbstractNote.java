package twelve;

/**
 * @author Geoffrey Liu
 * @since 1.0
 */
public abstract class AbstractNote implements Note {

	/**
	 * @see twelve.Note#getPitchClass()
	 */
	@Override
	public abstract PitchClass getPitchClass();

	/**
	 * @see twelve.Note#transpose(int)
	 */
	@Override
	public abstract Note transpose(int interval);

	/**
	 * @see twelve.Note#intervalTo(twelve.Note)
	 */
	@Override
	public int intervalTo(Note otherNote) {
		return otherNote.getPitchClass().degree() - this.getPitchClass().degree();
	}

}
