package NetworkDelayTime;

import java.util.Arrays;

class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            if(N == 1 || N == 0) {
                return 0;
            }
            int[] dis = new int[N];
            int[][] graph = new int[N][N];

            buildGraph(times, graph);
            dijkstra(graph, N, K - 1, dis);
            int max = 0;
            for (int d : dis) {
                if (d == Integer.MAX_VALUE) {
                    return -1;
                }
                if (d > max) {
                    max = d;
                }
            }

            if (max == 0) {
                return -1;
            } else {
                return max;
            }
        }

        public void dijkstra(int[][] graph, int N, int start, int[] dis) {
            boolean[] visited = new boolean[N];
            Arrays.fill(dis, Integer.MAX_VALUE);
            visited[start] = true;

            for (int i = 0; i < N; i++) {
                dis[i] = graph[start][i];
            }

            for (int i = 1; i < N; i++) {
                int min = Integer.MAX_VALUE;
                int k = 0;
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && dis[j] < min) {
                        min = dis[j];
                        k = j;
                    }
                }

                visited[k] = true;
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && graph[k][j] != Integer.MAX_VALUE && min + graph[k][j] < dis[j]) {
                        dis[j] = min + graph[k][j];
                    }
                }
            }
        }

        public void buildGraph(int[][] times, int[][] graph) {
            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(graph[i], Integer.MAX_VALUE);
                graph[i][i] = 0;
            }

            for (int[] time : times) {
                int from = time[0] - 1;
                int to = time[1] - 1;
                int w = time[2];
                graph[from][to] = w;
            }
        }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//        int[][] times = {{1,2,1}};
        int N = 4;
        int K = 2;
        System.out.println(new Solution().networkDelayTime(times, N, K));
    }
}