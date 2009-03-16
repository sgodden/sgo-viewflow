/**
 * 
 */
package org.sgodden.viewflow.impl;

import java.util.Set;

import org.sgodden.viewflow.Flow;
import org.sgodden.viewflow.FlowOutcome;
import org.sgodden.viewflow.View;
import org.sgodden.viewflow.ViewFlowOutcome;
import org.sgodden.viewflow.config.FlowStep;

/**
 * A flow outcome indicating that a certain view should be displayed.
 * @author goddens
 */
class ViewFlowOutcomeImpl extends FlowOutcomeImpl implements ViewFlowOutcome {

    private View view;
    private FlowStep viewFlowStep;

    ViewFlowOutcomeImpl(FlowImpl factory, View view,
            Flow nextFlowResolutionFactory, FlowOutcome previousFlowResolution,
            FlowStep viewFlowStep) {
        super(factory, nextFlowResolutionFactory, previousFlowResolution,
                viewFlowStep.getName(), viewFlowStep.getDescription());
        this.view = view;
        this.viewFlowStep = viewFlowStep;
    }

    public View getView() {
        return view;
    }

    public Set < String > getAvailableResolutions() {
        return viewFlowStep.getAvailableResolutions();
    }

}