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
package org.sgodden.viewflow.swing.testapp.flow1;

import org.apache.log4j.Logger;
import org.sgodden.viewflow.Context;
import org.sgodden.viewflow.ContextAware;

/**
 * A simulated implementation of a maintenance controller.
 * @author sgodden
 */
public class MaintenanceController implements ContextAware {
	
	private boolean fail = false;
    private static final Logger log = Logger.getLogger
            (MaintenanceController.class);
    
    private Context context;

    public void addOrderLine() {
        String s = (String) context.getFlowVariable("addedOrderLine");
        log.debug("Adding order line: " + s);
    }

    public void exportForValidate() {
        context.setFlowVariable("order", "ORDER SET BY FLOW 1");
        context.setFlowVariable("messageModel", "MESSAGE MODEL SET BY FLOW 1");
    }

    public boolean getFail() {
        return fail;
    }

    public void reload() {
        log.debug("Reloading");
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }

	public void setValidationFailed() {
	}

    public void setValidationSucceeded() {
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
