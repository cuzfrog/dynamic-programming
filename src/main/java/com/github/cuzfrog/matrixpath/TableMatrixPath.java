package com.github.cuzfrog.matrixpath;

final class TableMatrixPath implements MatrixPath {
    @Override
    public int pathCount(int n) {
        var m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    m[i][j] = 1;
                } else if (i == 0) {
                    m[i][j] = m[i][j-1];
                } else if (j == 0) {
                    m[i][j] = m[i-1][j];
                } else {
                    m[i][j] = m[i][j-1] + m[i-1][j];
                }
            }
        }
        return m[n-1][n-1];
    }
}
