package com.kvvssut.interviews.codinground.problems;

import java.util.ArrayList;
import java.util.List;

/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

Example 1:
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2

Example 2:
Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1

Constraints:
1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
 */
public class ConnectedComponentsInGraph {

    public static void main(String[] args) {
        ConnectedComponentsInGraph obj = new ConnectedComponentsInGraph();
        System.out.println(obj.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));    // output: 2
        System.out.println(obj.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));    // output: 1
    }

    public int countComponents(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        // Step 2: Track visited nodes
        boolean[] visited = new boolean[n];
        int components = 0;

        // Step 3: DFS over all nodes
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;        // Found a new component
                dfs(i, graph, visited);
            }
        }

        return components;
    }

    // DFS helper
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

}
