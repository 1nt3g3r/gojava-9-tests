package com.tests.unittest;

import java.util.Arrays;

public class QuadraticEquation {
    private static final float EPSILON = 0.000001f;

    private int a, b, c;
    private float discriminant;
    private float discriminantRoot;

    public void setCoeffs(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public RootHolder calc() {
        if (isAllCoeffsAreZero()) {
            return RootHolder.infiniteRoots();
        }

        calcDiscriminant();

        if (Float.isNaN(discriminantRoot)) {
            return RootHolder.noRoots();
        }

        if (isZero(discriminantRoot)) {
            return RootHolder.oneRoot(calcSingleRoot(1f));
        }

        float[] roots = calcSortedRoots();

        return RootHolder.twoRoots(roots[0], roots[1]);
    }

    private void calcDiscriminant() {
        discriminant = b*b - 4*a*c;
        discriminantRoot = (float) Math.sqrt(discriminant);
    }

    private boolean isZero(float number) {
        return Math.abs(number) <= EPSILON;
    }

    private float[] calcSortedRoots() {
        float[] roots = new float[] {
                calcSingleRoot(-1f),
                calcSingleRoot(1f)
        };

        Arrays.sort(roots);
        return roots;
    }

    private float calcSingleRoot(float sign) {
        return (-b + sign * discriminantRoot)/2f*a;
    }

    private boolean isAllCoeffsAreZero() {
        return a == 0 && b == 0 && c ==0;
    }
}