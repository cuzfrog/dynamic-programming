package com.github.cuzfrog.cansum;

import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.IntWormSet;

final class MemCanSum implements CanSum {
    @Override
    public boolean test(int targetSum, int[] nums) {
        return recurTest(targetSum, new IntBag(nums), new IntWormSet());
    }

    private static boolean recurTest(int targetSum, IntBag nums, IntSet mem) {
        if (targetSum < 0) return false;
        if (targetSum == 0) return true;
        if (mem.contains(targetSum)) {
            return false;
        }
        for (int i = 0; i < nums.length(); i++) {
            var num = nums.borrowElem(i);
            if (num < 0) {
                continue;
            }

            var residue = targetSum - num;
            var res = recurTest(residue, nums, mem);
            if (res) {
                return true;
            } else {
                mem.add(residue);
                nums.returnElem(i);
            }
        }
        return false;
    }
}
