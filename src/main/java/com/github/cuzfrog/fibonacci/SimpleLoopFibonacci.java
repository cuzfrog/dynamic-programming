package com.github.cuzfrog.fibonacci;

final class SimpleLoopFibonacci implements Fibonacci {
    @Override
    public long fib(int n) {
        if (n <= 2) {
            return 1;
        }
        long a = 1, b = 1, f = 0;
        for (int i = 3; i <= n; i++) {
            f = a + b;
            a = b;
            b = f;
        }
        return f;
    }
}
