package com.github.cuzfrog.word;

interface CanConstruct {
    /** Can str be constructed by words provided, a word can be reused if needed. */
    boolean test(String str, String[] words);
}
