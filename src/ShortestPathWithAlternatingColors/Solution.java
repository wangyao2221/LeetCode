package ShortestPathWithAlternatingColors;

import java.util.*;

/**
 * 无权图可以使用BFS来计算单源路径，但有权图不可以，原因是有权图最短路径往往与路径数量的多少没有关系
 * TODO 尝试将此题扩展为带权图的算法
 */
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] graph = new int[n][n];
        buildGraph(graph, n, red_edges, blue_edges);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1});
        q.offer(new int[]{0, -1});
        int[] result =  new int[n];
        int len = 0;
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();
            len++;

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int node = cur[0];
                int color = cur[1];
                int oppoColor = -color;
                // 注意这里没有更新路径长度的的才注意，这个不是Dijkstra算法
                for (int j = 0; j < n; j++) {
                    if (graph[node][j] == oppoColor || graph[node][j] == 0) {
                        if (visited.add(j + "" + oppoColor)) {
                            q.offer(new int[]{j, oppoColor});
                            result[j] = Math.min(result[j], len);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }

        return result;
    }

    public void buildGraph(int[][] graph, int n, int[][] red_edges, int[][] blue_edges) {
        for(int i = 0;i < graph.length; i++) {
            Arrays.fill(graph[i], n);
        }

        for(int[] red_edge : red_edges) {
            int from = red_edge[0];
            int to = red_edge[1];
            graph[from][to] = 1;
        }

        for(int[] blue_edge : blue_edges) {
            int from = blue_edge[0];
            int to = blue_edge[1];
            if (graph[from][to] == 1) {
                graph[from][to] = 0;
            } else {
                graph[from][to] = -1;
            }
        }
    }
}