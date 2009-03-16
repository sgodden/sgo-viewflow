package org.sgodden.viewflow.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.sgodden.viewflow.Flow;
import org.sgodden.viewflow.FlowOutcome;
import org.sgodden.viewflow.NamedObjectResolver;

/**
 * Abstract base class for flow resolutions.
 * 
 * @author goddens
 *
 */
class FlowOutcomeImpl
	implements FlowOutcome {
	
	/**
	 * The factory that created us.
	 */
	private final FlowImpl factory;
	private Flow nextFlowResolutionFactory;
	private FlowOutcome previousFlowResolution;
    private String flowStepName;
    private String flowStepDescription;

    FlowOutcomeImpl(
			FlowImpl factory, 
			Flow nextFlowResolutionFactory,
			FlowOutcome previousFlowResolution,
            String flowStepName,
            String flowStepDescription) {
		super();
		this.factory = factory;
		this.nextFlowResolutionFactory = nextFlowResolutionFactory;
		this.previousFlowResolution = previousFlowResolution;
        this.flowStepName = flowStepName;
        this.flowStepDescription = flowStepDescription;
    }

    /**
     * Returns the flow which generated this outcome.
     * @return the flow.
     */
    public Flow getFlow() {
        return factory;
    }

	public Flow getNextFlowResolutionFactory() {
		return nextFlowResolutionFactory;
	}

	public FlowOutcome getPreviousFlowResolution() {
		return previousFlowResolution;
	}

	public FlowOutcome getFlowOutcome(
			String controllerResolution) {
		return this.factory.getFlowOutcome(controllerResolution, this);
	}

    public String getFlowStepDescription() {
        return flowStepDescription;
    }

    public String getFlowStepName(){
        return flowStepName;
    }

    @Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("flowStepName", flowStepName)
            .append("flowStepDescription", flowStepDescription)
			.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see org.sgodden.ui.mvc.FlowResolution#getNamedObjectResolver()
	 */
	public NamedObjectResolver getNamedObjectResolver() {
		return factory;
	}
	
}