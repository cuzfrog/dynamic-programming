package com.github.cuzfrog.word;

final class RecursiveCanConstruct implements CanConstruct {
    @Override
    public boolean test(String str, String[] words) {
        if (str.isEmpty()) return true;

        for (String word : words) {
            if (str.startsWith(word)) {
                var res = test(str.substring(word.length()), words);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
}
