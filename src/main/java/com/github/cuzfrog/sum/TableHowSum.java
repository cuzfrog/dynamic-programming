package com.github.cuzfrog.sum;

import com.carrotsearch.hppc.IntArrayList;

final class TableHowSum implements HowSum {
    @Override
    public int[] test(int targetSum, int[] nums) {
        IntArrayList[] table = new IntArrayList[targetSum + 1];
        table[0] = new IntArrayList();

        all: for (int i = 0; i < table.length; i++) {
            if(table[i] == null) {
                continue;
            }
            for (int num : nums) {
                int next;
                if ((next = i + num) < table.length) {
                    var nextList = new IntArrayList(table[i]);
                    nextList.add(num);
                    table[next] = nextList;
                }
                if (next == targetSum) {
                    break all;
                }
            }
        }

        var res = table[targetSum];
        return res == null ? null : res.toArray();
    }
}
