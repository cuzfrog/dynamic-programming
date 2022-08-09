package com.github.cuzfrog.cansum;

import com.carrotsearch.hppc.IntArrayDeque;
import com.carrotsearch.hppc.IntDeque;

final class QueueCanSumReuseNum implements CanSumReuseNum {
    @Override
    public boolean test(int targetSum, int[] nums) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        IntDeque queue = new IntArrayDeque();
        queue.addLast(targetSum);
        while (!queue.isEmpty()) {
            var head = queue.removeFirst();
            for (int num : nums) {
                var residue = head - num;
                if (residue == 0) {
                    return true;
                }
                if (residue > 0) {
                    queue.addLast(residue);
                }
            }
        }
        return false;
    }
}
