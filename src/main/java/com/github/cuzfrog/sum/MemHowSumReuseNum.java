package com.github.cuzfrog.sum;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.IntWormSet;

final class MemHowSumReuseNum implements HowSumReuseNum {
    @Override
    public int[] test(int targetSum, int[] nums) {
        var res = recurTest(targetSum, nums, new IntWormSet());
        if (res != null) {
            return res.toArray();
        }
        return null;
    }

    private static IntArrayList recurTest(int targetSum, int[] nums, IntSet mem) {
        if (targetSum < 0) return null;
        if (targetSum == 0) return new IntArrayList();
        if (mem.contains(targetSum)) {
            return null;
        }

        for (int num : nums) {
            var residue = targetSum - num;
            var res = recurTest(residue, nums, mem);
            if (res != null) {
                res.add(num);
                return res;
            }
            mem.add(residue);
        }
        return null;
    }
}
