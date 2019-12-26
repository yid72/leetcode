package dyd.leetcode;

import java.util.*;

/**
 * 1245. Tree Diameter -- Medium
 *
 * Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.
 *
 * The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.  Each
 * node has labels in the set {0, 1, ..., edges.length}.
 *
 * Example 1:
 *
 * Input: edges = [[0,1],[0,2]]
 * Output: 2
 * Explanation:
 * A longest path of the tree is the path 1 - 0 - 2.
 * Example 2:
 *
 *
 *
 * Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * Output: 4
 * Explanation:
 * A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 *
 *
 * Constraints:
 *
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * The given edges form an undirected tree.
 */
public class Q01245_TreeDiameter {
    private int maxPath = 0;
    private Map<Integer, List<Integer>> graph;
    private boolean[] visited;

    public int treeDiameter(int[][] edges) {
        buildGraph(edges);
        visited = new boolean[edges.length + 1];
        dfs(0);
        return maxPath;
    }

    private void buildGraph(int[][] edges) {
        graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
    }

    private int dfs(int vertex) {
        visited[vertex] = true;

        int max1 = 0;
        int max2 = 0;
        for (int i : graph.get(vertex)) {
            if (!visited[i]) {
                int m = dfs(i);
                if (m > max1) {
                    max2 = max1;
                    max1 = m;
                } else if (m > max2) {
                    max2 = m;
                }
            }
        }
        maxPath = Math.max(maxPath, max1 + max2);

        return max1 + 1;
    }

    public static void main(String[] args) {
        test(new int[][] {
                {0,1},{1,2},{2,3},{1,4},{4,5}
        });
    }

    private static void test(int[][] edges) {
        Q01245_TreeDiameter q = new Q01245_TreeDiameter();
        System.out.printf("edges=%s: %d\n", Arrays.deepToString(edges), q.treeDiameter(edges));
    }
}
