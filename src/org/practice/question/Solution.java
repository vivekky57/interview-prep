package org.practice.question;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    Trie root = new Trie();

    public void insert(String word) {
        Trie curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public void dfs(int i, int j, char[][] board, int[][] vis, Trie node, List<String> ans, String word) {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length || vis[i][j] == 1) {
            return;
        }
        if (node.children[board[i][j] - 'a'] == null) {
            return;
        }

        vis[i][j] = 1;
        node = node.children[board[i][j] - 'a'];
        if (node.eow) {
            ans.add(word + board[i][j]);
        }
        dfs(i - 1, j, board, vis, node, ans, word + board[i][j]);
        dfs(i + 1, j, board, vis, node, ans, word + board[i][j]);
        dfs(i, j - 1, board, vis, node, ans, word + board[i][j]);
        dfs(i, j + 1, board, vis, node, ans, word + board[i][j]);
        vis[i][j] = 0;
    }

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            insert(word);
        }


        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(i, j, board, vis, root, ans, "");
                }
            }
        }
        return ans;
    }

    class Trie {
        Trie[] children;
        Boolean eow;

        Trie() {
            children = new Trie[26];
            eow = false;
        }
    }
}

