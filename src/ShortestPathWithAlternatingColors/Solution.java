package ShortestPathWithAlternatingColors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] graph = new int[n][n];
        int[] D = new int[n];
        boolean[] visited = new boolean[n];
        int[] path = new int[n];

        for (int i = 0; i < D.length; i++) {
            D[i] = n;
        }
        D[0] = 0;

        for (int[] red_edge : red_edges) {
            graph[red_edge[0]][red_edge[1]] = 1;
            if (red_edge[0] == 0) {
                D[red_edge[1]] = 1;
            }
        }

        for (int[] blue_edge : blue_edges) {
            graph[blue_edge[0]][blue_edge[1]] = -1;
            if (blue_edge[0] == 0) {
                D[blue_edge[1]] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int min = n;
            int min_index = 1;

            for (int j = 1; j < n; j++) {
                int pre_index = path[j];
                int pre_pre_index = path[pre_index];
                if (pre_index == pre_pre_index && !visited[j] && D[j] < min) {
                    min = D[j];
                    min_index = j;
                } else if (pre_index != pre_pre_index
                        && graph[pre_index][j] * graph[pre_pre_index][pre_index] < 0
                        && !visited[j]
                        && D[j] < min) {
                    min = D[j];
                    min_index = j;
                }
            }

            visited[min_index] = true;
            for (int j = 0; j < n; j++) {
                D[j] = Math.min(D[j], D[min_index] + Math.abs(graph[min][j]));
            }
        }

        for (int i = 0; i < D.length; i++) {
            if (D[i] == n) {
                D[i] = -1;
            }
        }

        return D;
    }

    public int[] shortestAlternatingPathsCopy(int n, int[][] red_edges, int[][] blue_edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        int[] D = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < D.length; i++) {
            D[i] = n;
        }
        D[0] = 0;

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] red_edge : red_edges) {
            graph.get(red_edge[0]).add(red_edge[1]);
            if (red_edge[0] == 0) {
                D[red_edge[1]] = 1;
            }
        }

        for (int[] blue_edge : blue_edges) {
            graph.get(blue_edge[0]).add(-blue_edge[1]);
            if (blue_edge[0] == 0) {
                D[blue_edge[1]] = 1;
            }
        }

        int flag = 1;
        for (int i = 1; i < n; i++) {
            int min = n;
            int min_index = 1;

            for (int j = 1; j < n; j++) {
                if (Math.abs(D[j]) < min) {
                    min = D[j];
                    min_index = j;
                }
            }
        }

        return D;
    }
}