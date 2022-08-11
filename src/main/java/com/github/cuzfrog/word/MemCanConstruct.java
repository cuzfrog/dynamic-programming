package com.github.cuzfrog.word;

import java.util.HashMap;
import java.util.Map;

final class MemCanConstruct implements CanConstruct {
    @Override
    public boolean test(String str, String[] words) {
        return recurTest(str, words, new HashMap<>());
    }

    private static boolean recurTest(String str, String[] words, Map<String, Boolean> mem) {
        if (str.isEmpty()) return true;
        var m = mem.get(str);
        if (m != null) {
            return m;
        }
        for (String word : words) {
            if (str.startsWith(word)) {
                var res = recurTest(str.substring(word.length()), words, mem);
                mem.put(str, res);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
}
