package com.tests.unittest;

import org.junit.Assert;
import org.junit.Test;

public class RootHolderTest {
    @Test
    public void testEquals() {
        Assert.assertEquals(RootHolder.noRoots(), RootHolder.noRoots());
        Assert.assertNotEquals(RootHolder.noRoots(), RootHolder.infiniteRoots());
    }
}
