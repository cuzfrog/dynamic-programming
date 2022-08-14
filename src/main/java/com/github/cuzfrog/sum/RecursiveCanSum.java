package com.github.cuzfrog.sum;

final class RecursiveCanSum implements CanSum {
    @Override
    public boolean test(int targetSum, int[] nums) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int num : nums) {
            var res = this.test(targetSum - num, nums);
            if (res) {
                return true;
            }
        }
        return false;
    }
}
