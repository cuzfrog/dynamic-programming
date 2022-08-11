package com.github.cuzfrog.sum;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.IntObjectHashMap;
import com.carrotsearch.hppc.IntObjectMap;

final class MemBestSumReuseNum implements BestSumReuseNum {
    @Override
    public int[] test(int targetSum, int[] nums) {
        var best = recurTest(targetSum, nums, new IntObjectHashMap<>());
        return best == null ? null : best.toArray();
    }

    private static IntArrayList recurTest(int targetSum, int[] nums, IntObjectMap<IntArrayList> mem) {
        if (targetSum <0) return null;
        if (targetSum == 0) return new IntArrayList();
        if (mem.containsKey(targetSum)) {
            return mem.get(targetSum);
        }

        IntArrayList best = null;
        for (int num : nums) {
            var reminder = targetSum - num;
            var res = recurTest(reminder, nums, mem);
            if (res != null) {
                res = new IntArrayList(res);
                res.add(num);
                if (best == null || best.size() > res.size()) {
                    best = res;
                }
            }
        }
        mem.put(targetSum, best);
        return best;
    }
}
