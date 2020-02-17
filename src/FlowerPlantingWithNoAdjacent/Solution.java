package FlowerPlantingWithNoAdjacent;

import java.util.*;

/**
 * Runtime: 35 ms, faster than 46.69% of Java online submissions for Flower Planting With No Adjacent.
 * Memory Usage: 54.2 MB, less than 100.00% of Java online submissions for Flower Planting With No Adjacent.
 * TODO 优化时间
 */
class Solution {
    boolean find = false;

    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] result = new int[N];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < paths.length; i++) {
            if (!graph.containsKey(paths[i][0])) {
                graph.put(paths[i][0], new ArrayList<Integer>());
            }
            graph.get(paths[i][0]).add(paths[i][1]);

            if (!graph.containsKey(paths[i][1])) {
                graph.put(paths[i][1], new ArrayList<Integer>());
            }
            graph.get(paths[i][1]).add(paths[i][0]);
        }

        help(result, N, graph, 1, 1);

        return result;
    }

    public void help(int[] result, int N, Map<Integer, List<Integer>> graph, int index, int type) {
        if (find) {
            return;
        }

        if (index > N) {
            find = true;
            return;
        }

        List<Integer> list = graph.get(index);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int index_ = list.get(i) - 1;
                if (result[index_] != 0 && result[index_] == type) {
                    return;
                }
            }
        }

        result[index - 1] = type;
        for (int i = 1; i <= 4; i++) {
            help(result, N, graph, index + 1, i);
        }
        if (!find) {
            result[index - 1] = 0;
        }
    }

    public static void main(String[] args) {
        int[] result = new Solution().gardenNoAdj(3, new  int[][]{{1, 2}, {2, 3}, {3, 1}});
        System.out.println(Arrays.toString(result));
        result = new Solution().gardenNoAdj(4, new  int[][]{{1, 2}, {3, 4}});
        System.out.println(Arrays.toString(result)); // [1,2,1,2]
        result = new Solution().gardenNoAdj(1, new  int[][]{});
        System.out.println(Arrays.toString(result));
    }
}