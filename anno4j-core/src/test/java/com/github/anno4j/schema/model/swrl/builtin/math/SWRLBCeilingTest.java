package com.github.anno4j.schema.model.swrl.builtin.math;

import com.github.anno4j.model.namespaces.SWRLB;
import com.github.anno4j.schema.model.swrl.Variable;
import com.github.anno4j.schema.model.swrl.builtin.AbstractSWRLBuiltinTest;
import com.github.anno4j.schema.model.swrl.engine.Bindings;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for SWRL built-in implementation {@link SWRLBCeiling}.
 */
public class SWRLBCeilingTest extends AbstractSWRLBuiltinTest {

    @Test
    public void testSPARQLFilterExpression() throws Exception {
        Variable x = createVariable();

        SWRLBCeiling builtin = instantiate(SWRLB.CEILING, 5.0, x);
        assertEquals("5.0 = ceil(?" + x.getVariableName() + ")", builtin.asSPARQLFilterExpression().toLowerCase());
    }

    @Test
    public void testEvaluate() throws Exception {
        assertTrue(instantiate(SWRLB.CEILING, 14L, 13.37).evaluate(new Bindings()));
        assertTrue(instantiate(SWRLB.CEILING, -13L, -13.37).evaluate(new Bindings()));
        assertFalse(instantiate(SWRLB.CEILING, 5L, 1.234).evaluate(new Bindings()));
    }
}