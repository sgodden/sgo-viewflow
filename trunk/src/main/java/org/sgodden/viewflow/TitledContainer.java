package org.sgodden.viewflow;

import java.io.Serializable;

/**
 * A container capable of displaying a title.
 * @author sgodden
 */
public interface TitledContainer extends Serializable {

    /**
     * Sets the title of the container.
     * @param title the title to display.
     */
    public void setTitle(String title);

}
