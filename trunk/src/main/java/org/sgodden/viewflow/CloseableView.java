package org.sgodden.viewflow;

/**
 * Denotes the capability of a view to be asked to close.
 * 
 * @author Lloyd Colling
 * 
 */
public interface CloseableView extends View {

	/**
	 * Asks the view to close, with a false return value indicating that the
	 * view cannot be closed.
	 * 
	 * @return
	 */
	public boolean closeView();

	/**
	 * Determines if the view can be closed
	 * 
	 * @return
	 */
	public boolean canClose();

	/**
	 * Gets the view to do anything that will allow closeView() to return true,
	 * and returns true if it succeeds, and false if it does not succeed
	 */
	public boolean prepareForClose();
}
