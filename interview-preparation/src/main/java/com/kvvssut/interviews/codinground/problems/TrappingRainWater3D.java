package com.kvvssut.interviews.codinground.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater3D {

    // Simple test
    public static void main(String[] args) {
        TrappingRainWater3D solution = new TrappingRainWater3D();

        int[][] heightMap1 = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        System.out.println("Trapped water (expected 4): " + solution.trapRainWater(heightMap1));

        int[][] heightMap2 = {
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3}
        };
        System.out.println("Trapped water (expected 10): " + solution.trapRainWater(heightMap2));

        int[][] heightMap3 = {
                {12, 13, 1, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}
        };
        System.out.println("Trapped water (expected 14): " + solution.trapRainWater(heightMap3));
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // Edge case: too small to trap water
        if (m <= 2 || n <= 2) return 0;

        // Min-heap to process cells starting from the lowest boundary
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));

        // Visited array to avoid re-processing the same cell
        boolean[][] visited = new boolean[m][n];

        // Step 1: Add all boundary cells to the min-heap
        // Left and right boundaries
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }

        // Top and bottom boundaries (excluding corners already added)
        for (int j = 1; j < n - 1; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }

        // Directions for 4-way BFS traversal (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int trappedWater = 0;

        // Step 2: Process cells in increasing height order
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            // Explore all 4 neighbors
            for (int[] dir : directions) {
                int nr = cell.row + dir[0];
                int nc = cell.col + dir[1];

                // Skip if out of bounds or already visited
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;

                visited[nr][nc] = true;

                // If the neighbor is lower than the current boundary, water is trapped
                if (heightMap[nr][nc] < cell.height) {
                    trappedWater += cell.height - heightMap[nr][nc];
                }

                // The neighbor becomes a new boundary with max of its height and current boundary
                int newHeight = Math.max(heightMap[nr][nc], cell.height);
                minHeap.offer(new Cell(nr, nc, newHeight));
            }
        }

        return trappedWater;
    }

    private record Cell(int row, int col, int height) {
    }
}
