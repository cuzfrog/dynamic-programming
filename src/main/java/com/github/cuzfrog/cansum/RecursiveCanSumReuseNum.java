package com.github.cuzfrog.cansum;

final class RecursiveCanSumReuseNum implements CanSumReuseNum {
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
