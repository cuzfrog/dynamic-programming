package com.github.cuzfrog.sum;

import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.IntWormSet;

final class MemCanSumReuseNum implements CanSumReuseNum {
    @Override
    public boolean test(int targetSum, int[] nums) {
        return recurTest(targetSum, nums, new IntWormSet());
    }

    private static boolean recurTest(int targetSum, int[] nums, IntSet mem) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        if (mem.contains(targetSum)) {
            return false;
        }
        for (int num : nums) {
            var residue = targetSum-num;
            var res = recurTest(residue, nums, mem);
            if (!res) {
                mem.add(residue);
            } else {
                return true;
            }
        }
        return false;
    }
}
