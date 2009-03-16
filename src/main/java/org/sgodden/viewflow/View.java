/* =================================================================
 # This library is free software; you can redistribute it and/or
 # modify it under the terms of the GNU Lesser General Public
 # License as published by the Free Software Foundation; either
 # version 2.1 of the License, or (at your option) any later version.
 #
 # This library is distributed in the hope that it will be useful,
 # but WITHOUT ANY WARRANTY; without even the implied warranty of
 # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 # Lesser General Public License for more details.
 #
 # You should have received a copy of the GNU Lesser General Public
 # License along with this library; if not, write to the Free Software
 # Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 #
 # ================================================================= */
package org.sgodden.viewflow;

/**
 * Interface for a view.
 */
public interface View {

    /**
     * Called immediately prior to a view being activated
     * for the first time.
     * <p>This is where views should perform initialisation
     * processing such as creating components.</p>
     * @param context the context for the current flow.
     */
    public void initialise(Context context);
    
    /**
     * Indicates that the view has been (re)placed into a container.
     */
    public void activate();
    
    /**
     * Returns the title that should be displayed for a view
     * @return
     */
    public String getTitle();

}
