package FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 这里注意不要设置为Integer.MAX，不然会溢出
        final int MAX = 9999999;
        int[][] D = new int[n][n];
//        int[][] path = new int[n][n];

        // 初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    D[i][j] = 0;
                } else {
                    D[i][j] = MAX;
                }
//                path[i][j] = -1;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int start = edge[0];
            int end = edge[1];
            int distance = edge[2];
            D[start][end] = distance;
            D[end][start] = distance;
        }

        // 计算点与点之间的最短路径
        // 注意第一层必须是k，不然计算的结果会有可能出现错误
        // 也就是必须求实每两点之间允许经过点1时的最短路径，然后在计算每两个点之间允许经过点1、2时的最短路径
        // 如果k在最里层，d[i][k]和d[k][j]一开始都不一定取了最小值的啊!它们和d[i][j]一样，会不断变小
        // 因此这个动态规划要解决的子问题就是任意i到j允许经过0时的最短路径，在计算允许经过1、2的最短路径
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        // 计算不超过阈值的的路径
        int result = -1;
        int minCount = n;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (D[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                result = i;
            }
        }

        return result;
    }

    public void showPath(int[][] path, int start, int end) {
        int pass = path[start][end];
        if (pass == -1) {
            return;
        }
        showPath(path, start, pass);
        System.out.print(pass + " ");
        showPath(path, pass, end);
    }

    public void show(int[][] matrix) {
        for (int[] p : matrix) {
            for (int node : p) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
//        int n = 5;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
//        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 4;
//        int distanceThreshold = 2;
        System.out.println(new Solution().findTheCity(n, edges, distanceThreshold));
    }
}