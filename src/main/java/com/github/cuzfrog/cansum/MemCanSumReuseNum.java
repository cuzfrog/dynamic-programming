package com.github.cuzfrog.cansum;

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
        var res = mem.contains(targetSum);
        if (res) {
            return true;
        }
        for (int num : nums) {
            var residue = targetSum-num;
            res = recurTest(residue, nums, mem);
            if (res) {
                mem.add(residue);
                return true;
            }
        }
        return false;
    }
}
