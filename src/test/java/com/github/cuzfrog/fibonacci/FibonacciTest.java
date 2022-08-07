package com.github.cuzfrog.fibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FibonacciTest {
    @Test
    void mem() {
        Fibonacci impl = new MemorizedFibonacci();
        assertThat(impl.fib(3)).isEqualTo(2);
        assertThat(impl.fib(20)).isEqualTo(6765L);
        assertThat(impl.fib(50)).isEqualTo(12586269025L);
    }

    @Test
    void loop() {
        Fibonacci impl = new SimpleLoopFibonacci();
        assertThat(impl.fib(3)).isEqualTo(2);
        assertThat(impl.fib(20)).isEqualTo(6765L);
        assertThat(impl.fib(50)).isEqualTo(12586269025L);
    }
}
