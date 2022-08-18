package com.github.cuzfrog.sum;

final class TableCanSum implements CanSum {
    @Override
    public boolean test(int targetSum, int[] nums) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if(!table[i]) {
                continue;
            }
            for (int num : nums) {
                int next;
                if ((next = i + num) < table.length) {
                    table[next] = table[i];
                }
            }
        }

        return table[targetSum];
    }
}
