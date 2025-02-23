package org.practice.leetcode.Contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class weeklyContest418 {

    public List<Integer> removeSuspiciousMethods(int n, int k, int[][] invocations) {
        // Step 1: Build an adjacency list from the invocations array
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] invocation : invocations) {
            adjList.get(invocation[0]).add(invocation[1]);
        }

        // Step 2: Perform DFS to find all suspicious methods
        Set<Integer> suspicious = new HashSet<>();
        boolean[] visited = new boolean[n];
        dfs(k, adjList, visited, suspicious);

        // Step 3: Check for external invocations into suspicious methods
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) { // if the method is not suspicious
                for (int invoked : adjList.get(i)) {
                    if (suspicious.contains(invoked)) {
                        // External invocation found, so it's not possible to remove the methods
                        return new ArrayList<>();
                    }
                }
            }
        }

        // Step 4: Collect the remaining methods
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    // DFS function to mark all suspicious methods starting from method `k`
    private void dfs(int method, List<List<Integer>> adjList, boolean[] visited, Set<Integer> suspicious) {
        visited[method] = true;
        suspicious.add(method);
        for (int invoked : adjList.get(method)) {
            if (!visited[invoked]) {
                dfs(invoked, adjList, visited, suspicious);
            }
        }
    }
    public static void main(String[] args) {
        weeklyContest418 solution = new weeklyContest418();
        int n = 4;
        int k = 1;
        int[][] invocations = {{1, 2}, {0, 1}, {3, 2}};
        System.out.println(solution.removeSuspiciousMethods(n, k, invocations));  // Output: [0, 1, 2, 3]
    }
}
