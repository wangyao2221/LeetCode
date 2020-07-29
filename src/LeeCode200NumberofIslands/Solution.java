package LeeCode200NumberofIslands;

import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;

        int count = 0;
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visit[i][j]) {
                    bfs(grid, visit, new Integer[]{i, j});
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, boolean[][] visit, Integer[] start) {
        int m = grid.length, n = grid[0].length;

        visit[start[0]][start[1]] = true;
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Integer[] loc = queue.poll();
            if(loc[0] - 1 >= 0 && grid[loc[0] - 1][loc[1]] == '1' && !visit[loc[0] - 1][loc[1]]) {
                queue.add(new Integer[]{loc[0] - 1, loc[1]});
                visit[loc[0] - 1][loc[1]] = true;
            } 
            if(loc[0] + 1 < m && grid[loc[0] + 1][loc[1]] == '1' && !visit[loc[0] + 1][loc[1]]) {
                queue.add(new Integer[]{loc[0] + 1, loc[1]});
                visit[loc[0] + 1][loc[1]] = true;
            }
            if(loc[1] - 1 >= 0 && grid[loc[0]][loc[1] - 1] == '1' && !visit[loc[0]][loc[1] - 1]) {
                queue.add(new Integer[]{loc[0], loc[1] - 1});
                visit[loc[0]][loc[1] - 1] = true;
            } 
            if(loc[1] + 1 < n && grid[loc[0]][loc[1] + 1] == '1' && !visit[loc[0]][loc[1] + 1]) {
                queue.add(new Integer[]{loc[0], loc[1] + 1});
                visit[loc[0]][loc[1] + 1] = true;
            } 
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1'}, {'0', '1' , '0'}, {'1', '1', '1'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }
}