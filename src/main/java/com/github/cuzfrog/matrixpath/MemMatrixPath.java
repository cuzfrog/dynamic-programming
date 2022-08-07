package com.github.cuzfrog.matrixpath;

import java.util.function.IntSupplier;

final class MemMatrixPath implements MatrixPath {
    @Override
    public int pathCount(int n) {
        return recurCnt(0, 0, n, new int[n +1][n +1]) + 1;
    }

    private static int recurCnt(int i, int j, int m, int[][] mem) {
        if (i >= m-1 && j >= m-1) {
            return 0;
        }
        if (i >= m-1) {
            return cache(i, j + 1, mem, () -> recurCnt(i, j + 1, m, mem));
        }
        if (j >= m-1) {
            return cache(i + 1, j, mem, () -> recurCnt(i + 1, j, m, mem));
        }

        return cache(i + 1, j, mem, () -> recurCnt(i + 1, j, m, mem)) + cache(i, j + 1, mem, () -> recurCnt(i, j + 1, m, mem)) + 1;
    }

    private static int cache(int i, int j, int[][] mem, IntSupplier calculate) {
        var prv = mem[i][j];
        if (prv > 0) {
            return prv;
        }
        var v = calculate.getAsInt();
        mem[i][j] = v;
        return v;
    }
}
