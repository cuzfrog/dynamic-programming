package com.github.cuzfrog.word;

final class RecursiveCountConstruct implements CountConstruct {
    @Override
    public int find(String str, String[] words) {
        return recurFind(str, words);
    }

    private static int recurFind(String str, String[] words) {
        if (str.isEmpty()) return 1;

        int ways = 0;
        for (String word : words) {
            if (str.startsWith(word)) {
                var suffix = str.substring(word.length());
                ways += recurFind(suffix, words);
            }
        }
        return ways;
    }
}
