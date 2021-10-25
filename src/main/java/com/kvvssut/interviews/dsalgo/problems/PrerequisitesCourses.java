package com.kvvssut.interviews.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PrerequisitesCourses {

    public static void main(String[] args) {
        System.out.println(new PrerequisitesCourses().canFinish(3, new int[][]{{1, 0}, {0, 2}, {2, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses + 1];

        for (int[] prereq : prerequisites) {
            List<Integer> prereqList = adjList[prereq[0]];
            if (prereqList == null) {
                prereqList = new ArrayList<>();
                adjList[prereq[0]] = prereqList;
            }
            prereqList.add(prereq[1]);
        }

        for (int i = 1; i <= numCourses; i++) {
            int[] visited = new int[numCourses + 1];
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (visited[node] == 0) {
                    List<Integer> dependents = adjList[node];
                    if (dependents != null) {
                        for (int depNode : dependents) {
                            if (depNode == i) {
                                return false;
                            }
                            stack.push(depNode);
                        }
                    }
                    visited[node] = 1;
                }
            }
        }

        return true;
    }
}