package com.github.cuzfrog.word;

import java.util.List;

interface AllConstruct {
    /** Find how all the ways the str can be constructed by words provided, a word can be reused if needed. */
    List<List<String>> find(String str, String[] words);
}
