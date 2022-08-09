package com.github.cuzfrog.sum;

interface CanSum {
    /**
     * Check if the sum can be achieved by adding any numbers from the nums provided.
     * A number can only be used once.
     * All numbers must be non-negative.
     */
    boolean test(int targetSum, int[] nums);
}
