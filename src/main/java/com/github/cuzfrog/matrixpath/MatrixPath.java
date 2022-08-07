package com.github.cuzfrog.matrixpath;

interface MatrixPath {
    /**
     * Calculate how many paths are there to travel from left up corner to right bottom corner. Can only go right or down
     * @param n size of the matrix is n x n
     * @return possible path count
     */
    int pathCount(int n);
}
