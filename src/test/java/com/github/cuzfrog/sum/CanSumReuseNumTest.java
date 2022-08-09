package com.github.cuzfrog.sum;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CanSumReuseNumTest {
    static Stream<CanSumReuseNum> impls() {
        return Stream.of(
                new RecursiveCanSumReuseNum(),
                new MemCanSumReuseNum(),
                new QueueCanSumReuseNum()
        );
    }

    @ParameterizedTest
    @MethodSource("impls")
    void test1(CanSumReuseNum impl) {
        assertThat(impl.test(3 , new int[]{1, 2})).isTrue();
        assertThat(impl.test(4 , new int[]{1, 2, 1})).isTrue();
        assertThat(impl.test(4 , new int[]{1, 4, 1})).isTrue();
        assertThat(impl.test(5 , new int[]{1, 2})).isTrue();
        assertThat(impl.test(6 , new int[]{2, 3})).isTrue();
        assertThat(impl.test(6 , new int[]{3, 4})).isTrue();
        assertThat(impl.test(6 , new int[]{4, 2})).isTrue();

        assertThat(impl.test(3 , new int[]{4, 5})).isFalse();
        assertThat(impl.test(4 , new int[]{3})).isFalse();
        assertThat(impl.test(6 , new int[]{4, 7, 5})).isFalse();
        assertThat(impl.test(8 , new int[]{3, 9, 6, 7})).isFalse();
    }
}
