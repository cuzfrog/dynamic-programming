package com.github.cuzfrog.word;

import java.util.HashMap;
import java.util.Map;

final class MemCountConstruct implements CountConstruct {
    @Override
    public int find(String str, String[] words) {
        return recurFind(str, words, new HashMap<>());
    }

    private static int recurFind(String str, String[] words, Map<String, Integer> mem) {
        if (str.isEmpty()) return 1;
        var m = mem.get(str);
        if (m != null) {
            return m;
        }

        int ways = 0;
        for (String word : words) {
            if (str.startsWith(word)) {
                var suffix = str.substring(word.length());
                ways += recurFind(suffix, words, mem);
            }
        }
        mem.put(str, ways);
        return ways;
    }
}
