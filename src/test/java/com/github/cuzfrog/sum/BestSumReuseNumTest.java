package com.github.cuzfrog.sum;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BestSumReuseNumTest {
    static Stream<BestSumReuseNum> impls() {
        return Stream.of(
                new RecursiveBestSumReuseNum()
        );
    }
    @ParameterizedTest
    @MethodSource("impls")
    void test1(BestSumReuseNum impl) {
        assertThat(impl.test(7, new int[]{7})).containsExactlyInAnyOrder(7);
        assertThat(impl.test(7, new int[]{3, 4})).containsExactlyInAnyOrder(3, 4);
        assertThat(impl.test(7, new int[]{3, 2})).containsExactlyInAnyOrder(3, 2 ,2);
        assertThat(impl.test(7, new int[]{2, 3})).containsExactlyInAnyOrder(3, 2 ,2);
        assertThat(impl.test(7, new int[]{1, 5})).containsExactlyInAnyOrder(5, 1 ,1);
        assertThat(impl.test(7, new int[]{2, 3, 1})).containsExactlyInAnyOrder(3, 2 ,2);
        assertThat(impl.test(7, new int[]{4, 3, 1})).containsExactlyInAnyOrder(3, 4);


        assertThat(impl.test(7, new int[]{7, 3, 4})).containsExactlyInAnyOrder(7);
        assertThat(impl.test(7, new int[]{1, 3, 4})).containsExactlyInAnyOrder(3, 4);

        assertThat(impl.test(7, new int[]{5, 4, 4})).isNull();

    }
}
