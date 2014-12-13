/**
 * 
 */
package model.set;

import java.util.ArrayList;
import java.util.List;

import model.note.Note;

/**
 * @author Geoffrey Liu
 */
public class ToneRowMatrix<E extends Note> {
	
	List<ToneRow<E>> matrix;

	/**
	 * Initialize the ToneRowMatrix with the given "base" tone-row 
	 */
	public ToneRowMatrix(ToneRow<E> baseRow) {
		matrix = new ArrayList<ToneRow<E>>(12);
		matrix.add(baseRow);
		computeMatrix();
	}
	
	/**
	 * Computes the remaining tone rows and puts them in order in the
	 *  tone row matrix
	 */
	private void computeMatrix() {
		// get the inversion of the base. this is needed to determine the
		// order of the rows
		ToneRow<E> inversion = getBase().inversion();
		
		for(int i = 1; i < 12; i++) {
			int interval = getBase().first().intervalTo(inversion.get(i));
			matrix.add(getBase().transposition(interval));
		}
	}
	
	/**
	 * Retrieves the base tone row
	 * @return the base tone row
	 */
	public ToneRow<E> getBase() {
		return matrix.get(0);
	}
	
	@Override
	public String toString() {
		StringBuilder rep = new StringBuilder();
		for(ToneRow<E> row : matrix) {
			rep.append("+--+--+--+--+--+--+--+--+--+--+--+--+\n|");
			for(E note : row) {
				rep.append(String.format("%1$-2s|", note.toString()));
			}
			rep.append("\n");
		}
		rep.append("+--+--+--+--+--+--+--+--+--+--+--+--+");
		return rep.toString();
	}

}
