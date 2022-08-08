package com.github.cuzfrog.matrixpath;

final class ReduceRecursiveMatrixPath implements MatrixPath {
    @Override
    public int pathCount(int n) {
        return recurCnt(n, n);
    }

    private static int recurCnt(int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (i == 1 && j == 1) return 1;
        return recurCnt(i - 1, j) + recurCnt(i, j - 1);
    }
}
