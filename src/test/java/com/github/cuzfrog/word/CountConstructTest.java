package com.github.cuzfrog.word;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CountConstructTest {
    static Stream<CountConstruct> impls() {
        return Stream.of(
                new RecursiveCountConstruct(),
                new MemCountConstruct()
        );
    }

    @ParameterizedTest
    @MethodSource("impls")
    void find(CountConstruct impl) {
        assertThat(impl.find("I have a PC which is superb.", new String[]{"superb", "is", "PC", "which", "a", "I", "have", " ", "."})).isEqualTo(1);
        assertThat(impl.find("abcd", new String[]{"ab", "bc", "abc", "cd", "d", "def"})).isEqualTo(2);
    }
}
