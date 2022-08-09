package com.github.cuzfrog.cansum;

import java.util.Arrays;

final class IntBag {
    private final int[] values;
    private final boolean[] existence;

    IntBag(int[] values) {
        this.values = values;
        this.existence = new boolean[values.length];
        Arrays.fill(this.existence, true);
    }

    private IntBag(int[] values, boolean[] existence) {
        this.values = values;
        this.existence = Arrays.copyOf(existence, existence.length);
    }

    int borrowElem(int index) {
        if (existence[index]) {
            existence[index] = false;
            return values[index];
        }
        return -1;
    }

    void returnElem(int index) {
        existence[index] = true;
    }

    int length() {
        return this.values.length;
    }

    IntBag copy() {
        return new IntBag(this.values, this.existence);
    }
}
