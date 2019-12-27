package dyd.leetcode;

import java.util.*;

/**
 * 261. Graph Valid Tree -- Medium
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function
 * to check whether these edges make up a valid tree.
 *
 * Example 1:
 *
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 *
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same
 * as [1,0] and thus will not appear together in edges.
 */
public class Q00261_GraphValidTree {
    private boolean[] visited;
    private Map<Integer, List<Integer>> adjacentLists;

    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) {
            return false;
        }

        visited = new boolean[n];

        int count = 0;
        adjacentLists = buildAdjacentLists(edges);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count ++;
                dfs(i);
            }
        }
        return count == 1;
    }

    private void dfs(int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        if (adjacentLists.containsKey(i)) {
            for (int j : adjacentLists.get(i)) {
                dfs(j);
            }
        }
    }

    private Map<Integer, List<Integer>> buildAdjacentLists(int[][] edges) {
        Map<Integer, List<Integer>> adjacentLists = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            adjacentLists.putIfAbsent(edges[i][0], new ArrayList<>());
            adjacentLists.putIfAbsent(edges[i][1], new ArrayList<>());
            adjacentLists.get(edges[i][0]).add(edges[i][1]);
            adjacentLists.get(edges[i][1]).add(edges[i][0]);
        }

        return adjacentLists;
    }

    public static void main(String[] args) {
        test(5, new int[][] {
                {0,1}, {0,2}, {0,3}, {1,4}
        });

        test(5, new int[][] {
                {0,1}, {1,2}, {2,3}, {1,3}, {1,4}
        });
    }

    private static void test(int n, int[][] edges) {
        Q00261_GraphValidTree q = new Q00261_GraphValidTree();
        System.out.printf("n=%d, edges=%s: %b\n", n, Arrays.deepToString(edges), q.validTree(n, edges));
    }
}
