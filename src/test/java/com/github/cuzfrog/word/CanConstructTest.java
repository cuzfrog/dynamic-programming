package com.github.cuzfrog.word;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CanConstructTest {
    static Stream<CanConstruct> impls() {
        return Stream.of(
                new RecursiveCanConstruct()
        );
    }

    @ParameterizedTest
    @MethodSource("impls")
    void test1(CanConstruct impl) {
        assertThat(impl.test("I have a PC which is superb.", new String[]{"superb", "is", "PC", "which", "a", "I", "have", " ", "."})).isTrue();

        assertThat(impl.test("I have a PC which is superb.", new String[]{"superb", "is", "PC", "which", "a", "I", " ", "."})).isFalse();
    }
}
