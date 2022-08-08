package com.github.cuzfrog.matrixpath;

final class ReduceMemMatrixPath implements MatrixPath {
    @Override
    public int pathCount(int n) {
        return recurCnt(n, n, new int[n+1][n+1]);
    }

    private static int recurCnt(int i, int j, int[][] mem) {
        if (i == 0 || j == 0) return 0;
        if (i == 1 && j == 1) return 1;
        var v = mem[i][j];
        if (v >0) return v;
        v = recurCnt(i - 1, j, mem) + recurCnt(i, j - 1, mem);
        mem[i][j] = v;
        return v;
    }
}
