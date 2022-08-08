package com.github.cuzfrog.matrixpath;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MatrixPathTest {
    static Stream<MatrixPath> impls() {
        return Stream.of(
                new GrowRecursiveMatrixPath(),
                new GrowMemMatrixPath(),
                new ReduceRecursiveMatrixPath(),
                new ReduceMemMatrixPath(),
                new ArrayMatrixPath()
        );
    };

    @ParameterizedTest
    @MethodSource("impls")
    void test(MatrixPath impl) {
        assertThat(impl.pathCount(2)).isEqualTo(2);
        assertThat(impl.pathCount(3)).isEqualTo(6);
        assertThat(impl.pathCount(4)).isEqualTo(20);
    }
}
