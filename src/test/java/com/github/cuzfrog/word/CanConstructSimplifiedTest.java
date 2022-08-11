package com.github.cuzfrog.word;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CanConstructSimplifiedTest {
    static Stream<CanConstructSimplified> impls() {
        return Stream.of(
                new LoopCanConstructSimplified()
        );
    }

    @ParameterizedTest
    @MethodSource("impls")
    void test1(CanConstructSimplified impl) {
        assertThat(impl.test("abcd".toCharArray(), "12354gheabcd".toCharArray())).isTrue();

        assertThat(impl.test("abcdz".toCharArray(), "12354gheabcd".toCharArray())).isFalse();
    }
}
