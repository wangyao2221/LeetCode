package WeeklyContest147.Largest1BorderedSquare;

class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0) return 0;

        int height = grid.length;
        int width = grid[0].length;

        int min = Math.min(height, width);

        for (int i = min; i > 0; i--) {
            for (int j = 0; j <= height - i; j++) {
                for (int k = 0; k <= width - i; k++) {
                    boolean flag = checkSquare(grid, i, j, k);
                    if (flag) return i * i;
                }
            }
        }

        return 0;
    }

    public boolean checkSquare(int[][] grid, int width, int x, int y) {
        for (int i = 0; i < width; i++) {
            if (grid[x][y + i] == 0) return false;
        }

        for (int i = 0; i < width; i++) {
            if (grid[x + width - 1][y + i] == 0) return false;
        }

        for (int i = 0; i < width; i++) {
            if (grid[x + i][y] == 0) return false;
        }

        for (int i = 0; i < width; i++) {
            if (grid[x + i][y + width - 1] == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] grid = {{0,0},{0,1}};
//        int[][] grid = {{0}};
//        int[][] grid = {{0,1,1,1,0},{0,1,0,1,0},{0,1,1,1,0}};

        System.out.println(new Solution().largest1BorderedSquare(grid));
    }
}