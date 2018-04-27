package com.tests.unittest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class QuadraticEquationTest {
    private static final float EPSILON = 0.000001f;

    @Test
    public void test2Roots() {
        testRoots(1, -3, 2, RootHolder.twoRoots(1f, 2f));
    }

    @Test
    public void test2RootsInverseOrder() {
        testRoots(-1, 4, 5, RootHolder.twoRoots(-1f, 5f));
    }

    @Test
    public void test1Root() {
        testRoots(1, 2, 1, RootHolder.oneRoot(-1f));
    }

    @Test
    public void testNoRoots() {
        testRoots(1, 1, 5, RootHolder.noRoots());
    }

    @Test
    public void testInfiniteCountRoots() {
        testRoots(0, 0, 0, RootHolder.infiniteRoots());
    }

    private void testRoots(int a, int b, int c, RootHolder expectedRoots) {
        QuadraticEquation equation = new QuadraticEquation();
        equation.setCoeffs(a, b, c);
        RootHolder actualRoots = equation.calc();

        Assert.assertEquals(expectedRoots, actualRoots);
    }
}
