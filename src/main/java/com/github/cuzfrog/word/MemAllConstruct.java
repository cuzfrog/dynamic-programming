package com.github.cuzfrog.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class MemAllConstruct implements AllConstruct {
    @Override
    public List<List<String>> find(String str, String[] words) {
        return recurFind(str, words, new HashMap<>());
    }

    private static List<List<String>> recurFind(String str, String[] words, Map<String, List<List<String>>> mem) {
        if (str.isEmpty()) return emptyEnd();
        if (mem.containsKey(str)) {
            return mem.get(str);
        }

        List<List<String>> all = new ArrayList<>();
        for (String word : words) {
            if (str.startsWith(word)) {
                var suffix = str.substring(word.length());
                var res = recurFind(suffix, words, mem);
                for (List<String> l : res) {
                    var list = new ArrayList<>(l);
                    list.add(word);
                    all.add(list);
                }
            }
        }
        mem.put(str, all);

        return all;
    }

    private static List<List<String>> emptyEnd() {
        var l = new ArrayList<List<String>>();
        l.add(new ArrayList<>());
        return l;
    }
}
