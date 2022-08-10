package com.github.cuzfrog.sum;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
final class HowSumReuseNumTest {

    static Stream<HowSumReuseNum> impls() {
        return Stream.of(
                new RecursiveHowSumReuseNum(),
                new MemHowSumReuseNum()
        );
    }

    @ParameterizedTest
    @MethodSource("impls")
    void test1(HowSumReuseNum impl) {
        assertThat(impl.test(7, new int[]{3, 4})).containsExactlyInAnyOrder(3,4);
        assertThat(impl.test(7, new int[]{2, 3})).containsExactlyInAnyOrder(2,2,3);

        assertThat(impl.test(7, new int[]{5, 3})).isNull();
    }
}
