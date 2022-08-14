package com.github.cuzfrog.word;

import java.util.ArrayList;
import java.util.List;

final class RecursiveAllConstruct implements AllConstruct {
    @Override
    public List<List<String>> find(String str, String[] words) {
        return recurFind(str, words);
    }

    private static List<List<String>> recurFind(String str, String[] words) {
        if (str.isEmpty()) return emptyEnd();

        List<List<String>> all = new ArrayList<>();
        for (String word : words) {
            if (str.startsWith(word)) {
                var suffix = str.substring(word.length());
                var res = recurFind(suffix, words);
                for (List<String> l : res) {
                    l.add(word);
                    all.add(l);
                }
            }
        }
        return all;
    }

    private static List<List<String>> emptyEnd() {
        var l = new ArrayList<List<String>>();
        l.add(new ArrayList<>());
        return l;
    }
}
