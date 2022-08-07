package com.github.cuzfrog.matrixpath;

final class RecursiveMatrixPath implements MatrixPath {
    @Override
    public int pathCount(int n) {
        return recurCnt(1, 1, n) + 1;
    }

    private static int recurCnt(int i, int j, int m) {
        if (i >= m && j >= m) {
            return 0;
        }
        if (i >= m) {
            return recurCnt(i, j + 1, m);
        }
        if (j >= m) {
            return recurCnt(i + 1, j, m);
        }
        return recurCnt(i + 1, j, m) + recurCnt(i, j + 1, m) + 1;
    }
}
