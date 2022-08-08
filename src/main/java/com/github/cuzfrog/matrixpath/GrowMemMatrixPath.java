package com.github.cuzfrog.matrixpath;

final class GrowMemMatrixPath implements MatrixPath {
    @Override
    public int pathCount(int n) {
        return recurCnt(0, 0, n, new int[n +1][n +1]) + 1;
    }

    private static int recurCnt(int i, int j, int m, int[][] mem) {
        var prv = mem[i][j];
        if (prv > 0) {
            return prv;
        }

        if (i >= m-1 && j >= m-1) {
            return 0;
        }
        if (i >= m-1) {
            return recurCnt(i, j + 1, m, mem);
        }
        if (j >= m-1) {
            return recurCnt(i + 1, j, m, mem);
        }

        var v = recurCnt(i + 1, j, m, mem) + recurCnt(i, j + 1, m, mem) + 1;
        mem[i][j] = v;
        return v;
    }
}
