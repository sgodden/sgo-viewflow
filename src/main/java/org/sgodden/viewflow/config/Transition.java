package org.sgodden.viewflow.config;

import java.io.Serializable;

import org.sgodden.viewflow.impl.Guard;

/**
 * A transition from one flow step to another.
 * @author sgodden
 *
 */
public class Transition implements Serializable {
	
	private static final long serialVersionUID = 20091020L;
	
	private String on;
    private String to;
    private Guard guard;
    private String[] controllerMethods;
    
    /**
     * Returns the event that triggers this transition.
     * @return the event that triggers this transition.
     */
    public String getOn() {
        return on;
    }
    public void setOn(String on) {
        this.on = on;
    }
    
    /**
     * Returns the name of the destination step.
     * @return the name of the destination step.
     */
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    
    /**
     * Returns the guard that should evaluate to true
     * for this transition to be selected.
     * @return the guard.
     */
    public Guard getGuard() {
        return guard;
    }
    public void setGuard(Guard guard) {
        this.guard = guard;
    }
    
    /**
     * Returns the controller methods that should be invoked
     * when this transition is selected.
     * @return the controller methods.
     */
    public String[] getControllerMethods() {
        return controllerMethods;
    }
    public void setControllerMethods(String[] controllerMethods) {
        this.controllerMethods = controllerMethods;
    }

}
