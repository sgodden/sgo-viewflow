package org.sgodden.viewflow.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A step in a page flow.
 * @author sgodden
 *
 */
public class FlowStep {
    
    private Set < String > availableResolutions = new HashSet < String >();
    private String controllerMethod;
    private String controllerName;
    private String description;
    private String endState;
    private String[] entryControllerMethods;
    private String[] exitControllerMethods;
    private String name;
    private Map < String, String > subFlowInputParameters;
    private String subFlowName;
    private Map < String, String > subFlowOutputParameters;
    private Transition[] transitions;
    private Map < String, Set< Transition > > transitionsByName;
    private String viewName;
    
    public void setTransitions(Transition[] transitions) {
        this.transitions = transitions;
        transitionsByName = new HashMap < String, Set < Transition > >();
        for (Transition t : transitions) {
            if ( t.getOn() == null ) {
                throw new IllegalArgumentException("The 'on' attribute of a transition must be specified");
            }
            availableResolutions.add(t.getOn());
            Set< Transition > sub;
            if (transitionsByName.get(t.getOn()) == null) {
                sub = new HashSet < Transition >();
                transitionsByName.put(t.getOn(), sub);
            }
            else {
                sub = transitionsByName.get(t.getOn());
            }
            sub.add(t);
        }
    }
    
    public Set < Transition > getTransitions(String on) {
        if (transitionsByName.get(on) != null) {
            return Collections.unmodifiableSet(transitionsByName.get(on));
        }
        else {
            return null;
        }
    }
    
    public Set < String > getAvailableResolutions() {
        return Collections.unmodifiableSet(availableResolutions);
    }

    public String getControllerMethod() {
        return controllerMethod;
    }

    public void setControllerMethod(String controllerMethod) {
        this.controllerMethod = controllerMethod;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndState() {
        return endState;
    }

    public void setEndState(String endState) {
        this.endState = endState;
    }

    public String[] getEntryControllerMethods() {
        return entryControllerMethods;
    }

    public void setEntryControllerMethods(String[] entryControllerMethods) {
        this.entryControllerMethods = entryControllerMethods;
    }

    public String[] getExitControllerMethods() {
        return exitControllerMethods;
    }

    public void setExitControllerMethods(String[] exitControllerMethods) {
        this.exitControllerMethods = exitControllerMethods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getSubFlowInputParameters() {
        return subFlowInputParameters;
    }

    public void setSubFlowInputParameters(Map<String, String> subFlowInputParameters) {
        this.subFlowInputParameters = subFlowInputParameters;
    }

    public String getSubFlowName() {
        return subFlowName;
    }

    public void setSubFlowName(String subFlowName) {
        this.subFlowName = subFlowName;
    }

    public Map<String, String> getSubFlowOutputParameters() {
        return subFlowOutputParameters;
    }

    public void setSubFlowOutputParameters(
            Map<String, String> subFlowOutputParameters) {
        this.subFlowOutputParameters = subFlowOutputParameters;
    }

    public Map<String, Set<Transition>> getTransitionsByName() {
        return transitionsByName;
    }

    public void setTransitionsByName(Map<String, Set<Transition>> transitionsByName) {
        this.transitionsByName = transitionsByName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    public void setAvailableResolutions(Set<String> availableResolutions) {
        this.availableResolutions = availableResolutions;
    }

}
