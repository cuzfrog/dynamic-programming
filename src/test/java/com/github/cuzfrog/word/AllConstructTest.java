package com.github.cuzfrog.word;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AllConstructTest {
    static Stream<AllConstruct> impls() {
        return Stream.of(
                new RecursiveAllConstruct()
        );
    }
    @ParameterizedTest
    @MethodSource("impls")
    void find(AllConstruct impl) {
        assertThat(impl.find("abcd", new String[]{"abc", "ab", "d", "cd"})).containsExactlyInAnyOrder(List.of("d", "abc"), List.of("cd", "ab"));
    }
}
