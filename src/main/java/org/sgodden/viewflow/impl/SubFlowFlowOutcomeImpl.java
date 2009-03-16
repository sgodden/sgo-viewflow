package org.sgodden.viewflow.impl;


/**
 * A dummy implementation of FlowResolution for use
 * when calling sub-flows.
 * <p/>
 * This wraps the previous flow resolution for this factory, so
 * that when the sub-flow completes, control will be returned 
 * to the last controller that was active for this flow.
 * 
 * @author goddens
 *
 */
class SubFlowFlowOutcomeImpl {
	
}