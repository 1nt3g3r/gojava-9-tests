package com.tests.unittest;

import java.util.Arrays;

public class RootHolder {
    private ResultType resultType;
    private float[] roots;

    public RootHolder() {
    }

    public RootHolder(ResultType resultType, float ... roots) {
        this.resultType = resultType;
        this.roots = roots;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public float[] getRoots() {
        return roots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RootHolder that = (RootHolder) o;

        if (resultType != that.resultType) return false;
        return Arrays.equals(roots, that.roots);
    }

    @Override
    public int hashCode() {
        int result = resultType.hashCode();
        result = 31 * result + Arrays.hashCode(roots);
        return result;
    }

    public static RootHolder twoRoots(float root1, float root2) {
        return new RootHolder(ResultType.twoRoots, root1, root2);
    }

    public static RootHolder oneRoot(float root) {
        return new RootHolder(ResultType.oneRoot, root);
    }

    public static RootHolder infiniteRoots() {
        return new RootHolder(ResultType.infiniteRootCount);
    }

    public static RootHolder noRoots() {
        return new RootHolder(ResultType.noRoots);
    }
}
