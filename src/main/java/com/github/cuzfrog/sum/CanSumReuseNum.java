package com.github.cuzfrog.sum;

interface CanSumReuseNum {
    /**
     * Check if the sum can be achieved by adding any numbers from the nums provided.
     * A number can be used as many times as needed.
     * All numbers must be non-negative.
     */
    boolean test(int targetSum, int[] nums);
}
