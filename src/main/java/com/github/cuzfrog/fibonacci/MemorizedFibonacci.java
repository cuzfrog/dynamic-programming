package com.github.cuzfrog.fibonacci;

final class MemorizedFibonacci implements Fibonacci {
    @Override
    public long fib(int n) {
        if (n <= 2) {
            return 1;
        }
        var mem = new long[n+1];
        mem[1] = 1;
        mem[2] = 1;
        return memFib(n, mem);
    }

    private static long memFib(int n, long[] mem) {
        if (n <= 2) {
            return 1;
        }
        var v = memFib(n - 1, mem) + mem[n-2];
        mem[n] = v;
        return v;
    }
}
