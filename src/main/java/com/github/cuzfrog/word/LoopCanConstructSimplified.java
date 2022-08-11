package com.github.cuzfrog.word;

final class LoopCanConstructSimplified implements CanConstructSimplified {
    @Override
    public boolean test(char[] string, char[] words) {
        for (char c : string) {
            boolean found = false;
            for (char word : words) {
                if (c == word) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
