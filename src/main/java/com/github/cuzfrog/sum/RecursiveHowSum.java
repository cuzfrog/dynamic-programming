package com.github.cuzfrog.sum;

import com.carrotsearch.hppc.IntArrayList;

final class RecursiveHowSum implements HowSum {
    @Override
    public int[] test(int targetSum, int[] nums) {
        var res = recurTest(targetSum, nums);
        if (res != null) {
            return res.toArray();
        }
        return null;
    }

    private static IntArrayList recurTest(int targetSum, int[] nums) {
        if (targetSum < 0) return null;
        if (targetSum == 0) return new IntArrayList();
        for (int num : nums) {
            var res = recurTest(targetSum - num, nums);
            if (res != null) {
                res.add(num);
                return res;
            }
        }
        return null;
    }
}
