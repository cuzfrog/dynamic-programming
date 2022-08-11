package com.github.cuzfrog.word;

interface CountConstruct {
    /** Find how many ways the str can be constructed by words provided, a word can be reused if needed. */
    int find(String str, String[] words);
}
