package org.sgodden.viewflow.samples;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

@Test
public class SubFlowTest {
    
    public void testSubFlow() {
    	SubFlow subFlow = new SubFlow();
    	assertFalse(subFlow.getStepsByName().containsKey("foo2"));
    	assertTrue(subFlow.getStepsByName().containsKey("subFoo"));
    	assertFalse(subFlow.getStepsByName().get("foo")
    			.getTransitionsByName().containsKey("toBeRemovedBySubFlow"));
    	assertTrue(subFlow.getStepsByName().get("foo")
    			.getTransitionsByName().containsKey("insertedBySubFlow"));
    }

}
