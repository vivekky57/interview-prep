package org.practice.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie {
    Node some;

    public Trie() {
        some = new Node();
    }

    public void insert(String word) {
        some.insert(word);
    }

    public boolean search(String word) {
        return some.search(word);
    }

    public boolean startsWith(String prefix) {
        return some.startWith(prefix);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int l = 0, r = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = Arrays.stream(products).toList();
            char ch = searchWord.charAt(i);
            while (l <= r && (list.get(l).length() <= i || list.get(l).charAt(i) != ch)) {
                l++;
            }
            while (l <= r && (list.get(r).length() <= i || list.get(r).charAt(i) != ch)) {
                r--;
            }
            res.add(new ArrayList<>());
            int remain = Math.min(3, r - l + 1);
            for (int j = 0; j < remain; j++) {
                res.getLast().add(list.get(j + l));
            }
        }
        return res;
    }

    static class Node {
        static Node root = new Node();
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                if (i == word.length() - 1) {
                    curr.children[idx].eow = true;
                }
                curr = curr.children[idx];
            }
        }

        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    return false;
                }
                if (i == word.length() - 1 && !curr.children[idx].eow) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return true;
        }

        public boolean startWith(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    return false;
                }
//                if (i == word.length() - 1 ) {
//                    return true;
//                }
                curr = curr.children[idx];
            }
            return true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */