package com.github.cuzfrog.cansum;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CanSumTest {
    static Stream<CanSum> impls() {
        return Stream.of(
                new RecursiveCanSum()
        );
    }

    @ParameterizedTest
    @MethodSource("impls")
    void test1(CanSum impl) {
        assertThat(impl.test(3 , new int[]{1, 2})).isTrue();
        assertThat(impl.test(4 , new int[]{1, 2, 1})).isTrue();
        assertThat(impl.test(4 , new int[]{1, 4, 1})).isTrue();
        assertThat(impl.test(5 , new int[]{1, 2, 1, 2})).isTrue();
        assertThat(impl.test(6 , new int[]{1, 3, 1, 2})).isTrue();
        assertThat(impl.test(6 , new int[]{1, 2, 4, 2})).isTrue();
        assertThat(impl.test(6 , new int[]{1, 2, 2, 2})).isTrue();

        assertThat(impl.test(3 , new int[]{1, 1})).isFalse();
        assertThat(impl.test(4 , new int[]{1, 5, 1})).isFalse();
        assertThat(impl.test(5 , new int[]{1, 0, 1, 2})).isFalse();
        assertThat(impl.test(6 , new int[]{1, 7, 1, 2})).isFalse();
        assertThat(impl.test(6 , new int[]{1, 1, 1, 2})).isFalse();
        assertThat(impl.test(6 , new int[]{1, 0, 2, 2})).isFalse();
    }
}
