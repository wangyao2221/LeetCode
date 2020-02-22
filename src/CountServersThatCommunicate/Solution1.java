package CountServersThatCommunicate;

// TODO 看一下这个解法 https://leetcode.com/problems/count-servers-that-communicate/discuss/480708/easy-understand
class Solution1 {
    public int countServers(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int result = 0;

        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[][] servers = {{1, 0}, {1, 1}};
        int[][] servers = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(new Solution1().countServers(servers));
    }
}