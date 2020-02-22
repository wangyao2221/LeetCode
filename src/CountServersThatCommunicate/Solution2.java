package CountServersThatCommunicate;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public int countServers(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int result = 0;
        List<Integer[]> records = new ArrayList<>();

        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                    records.add(new Integer[]{i, j});
                }
            }
        }

        for (Integer[] record : records) {
            if (rowCount[record[0]] > 1 || colCount[record[1]] > 1) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[][] servers = {{1, 0}, {1, 1}};
        int[][] servers = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(new Solution2().countServers(servers));
    }
}