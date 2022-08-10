package com.github.cuzfrog.sum;

import com.carrotsearch.hppc.IntArrayList;

final class RecursiveBestSumReuseNum implements BestSumReuseNum {
    @Override
    public int[] test(int targetSum, int[] nums) {
        var best = recurTest(targetSum, nums);
        return best == null ? null : best.toArray();
    }

    private static IntArrayList recurTest(int targetSum, int[] nums) {
        if (targetSum <0) return null;
        if (targetSum == 0) return new IntArrayList();

        IntArrayList best = null;
        for (int num : nums) {
            var reminder = targetSum - num;
            var res = recurTest(reminder, nums);
            if (res != null) {
                res.add(num);
                if (best == null) {
                    best = res;
                } else {
                    if (best.size() > res.size()) {
                        best = res;
                    }
                }
            }
        }
        return best;
    }
}
