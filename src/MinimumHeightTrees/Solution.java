package MinimumHeightTrees;

import java.util.*;

/**
 * 这题题目有个要注意的点：For an undirected graph with tree characteristics
 * 一个具有书特征的图，所以不需要考虑图中带环
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        /** 初始化图 **/
        int[] degree = new int[n];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        /** BFS **/
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            result = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                result.add(node);
                for (Integer neighbor : graph.get(node)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        List<Integer> result = new Solution().findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        List<Integer> result = new Solution().findMinHeightTrees(1, new int[][]{});
        result.forEach(System.out::println);
    }
}