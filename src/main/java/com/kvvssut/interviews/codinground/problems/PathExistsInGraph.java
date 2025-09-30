package com.kvvssut.interviews.codinground.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExistsInGraph {

    public static void main(String[] args) {
        PathExistsInGraph obj = new PathExistsInGraph();

        // Test Case 1
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        int source1 = 0, destination1 = 2;
        System.out.println("Test 1: " + obj.validPathBFS(n1, edges1, source1, destination1));
        // Expected: true (0 -> 2 exists)

        // Test Case 2
        int n2 = 6;
        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source2 = 0, destination2 = 5;
        System.out.println("Test 2: " + obj.validPathBFS(n2, edges2, source2, destination2));
        // Expected: false (0's component disconnected from 5)

        // Test Case 3
        int n3 = 4;
        int[][] edges3 = {{0, 1}, {1, 2}, {2, 3}};
        int source3 = 0, destination3 = 3;
        System.out.println("Test 3: " + obj.validPathDFS(n3, edges3, source3, destination3));
        // Expected: true (path exists 0 -> 1 -> 2 -> 3)
    }

    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        // Step 1: Build adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Since the graph is undirected, add both directions (u <-> v)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Step 2: Track visited nodes
        boolean[] visited = new boolean[n];

        // Step 3: Perform BFS starting from the source
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // If we reach the destination, return true
            if (current == destination) {
                return true;
            }

            // Explore all unvisited neighbors
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // If BFS completes without finding destination, no path exists
        return false;
    }

    public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        // Step 1: Build adjacency list for the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Since the graph is undirected, add both directions (u -> v and v -> u)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Step 2: Track visited nodes to prevent revisiting
        boolean[] visited = new boolean[n];

        // Step 3: Perform DFS starting from the source node
        return dfs(source, destination, adjList, visited);
    }

    private boolean dfs(int node, int destination, List<List<Integer>> adjList, boolean[] visited) {
        // Base case: if current node is the destination
        if (node == destination) return true;

        // Mark current node as visited
        visited[node] = true;

        // Explore all unvisited neighbors
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                // If any neighbor leads to destination, return true
                if (dfs(neighbor, destination, adjList, visited)) {
                    return true;
                }
            }
        }

        // No path found from this branch
        return false;
    }
}
