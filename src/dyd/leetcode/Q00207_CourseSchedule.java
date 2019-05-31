package dyd.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class Q00207_CourseSchedule {
    private int numCourses;
    private boolean[] visited;
    private List<Integer>[] ajacencyList;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        visited = new boolean[numCourses];
        buildAjacencyLists(numCourses, prerequisites);
        return !hasCycleDfs();
    }

    private void buildAjacencyLists(int numCourses, int[][] prerequisites) {
        ajacencyList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ajacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            ajacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
    }

    private boolean hasCycleDfs() {
        Set<Integer> currentPath = new HashSet<>();
        for (int i = 0; i < numCourses; i ++) {
            if (!visited[i]) {
               if (hasCycleDfs(currentPath, i)) {
                   return true;
               }
            }
        }
        return false;
    }

    private boolean hasCycleDfs(Set<Integer> currentPath, int x) {
        currentPath.add(x);
        visited[x] = true;
        for (int y : ajacencyList[x]) {
            if (currentPath.contains(y)) {
                return true;
            } else if (!visited[y]) {
                if (hasCycleDfs(currentPath, y)) {
                    return true;
                }
            }
        }
        currentPath.remove(x);

        return false;
    }

    @Test
    public void test1() {
        Q00207_CourseSchedule q = new Q00207_CourseSchedule();
        assertTrue(q.canFinish(2, new int[][] {{1, 0}}));
    }

    @Test
    public void test2() {
        Q00207_CourseSchedule q = new Q00207_CourseSchedule();
        assertFalse(q.canFinish(2, new int[][] {{1, 0}, {0,1}}));
    }
}
