package com.github.cuzfrog.sum;

interface BestSum {
    /**
     * Find a combination from given nums that can add up to the target sum.
     * @return the shortest possible combination of the numbers, or null if not possible.
     */
    int[] test(int targetSum, int[] nums);
}
