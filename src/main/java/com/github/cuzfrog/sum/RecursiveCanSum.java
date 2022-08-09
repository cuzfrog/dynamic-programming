package com.github.cuzfrog.sum;

final class RecursiveCanSum implements CanSum {
    @Override
    public boolean test(int targetSum, int[] nums) {
        return recurTest(targetSum, new IntBag(nums));
    }

    private static boolean recurTest(int targetSum, IntBag bag) {
        if (targetSum < 0) return false;
        if (targetSum == 0) return true;
        for (int i = 0; i < bag.length(); i++) {
            var num = bag.borrowElem(i);
            if (num > 0) {
                var res = recurTest(targetSum - num, bag.copy());
                if (res) return true;
            }
        }
        return false;
    }
}
