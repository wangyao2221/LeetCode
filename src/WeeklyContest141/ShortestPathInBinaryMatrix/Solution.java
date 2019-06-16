package WeeklyContest141.ShortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;

        int n = grid.length;
        int m = grid[0].length;
        Queue<Position> positionQueue = new LinkedList<Position>() {
            {
                offer(new Position(0, 0, 0));
            }
        };

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

        while (!positionQueue.isEmpty()) {
            Position position = positionQueue.poll();
            int i = position.x;
            int j = position.y;
            if (i == n - 1 && j == m - 1) return position.steps + 1;

            for (int k = 0; k < dir.length; k++) {
                int posX = i + dir[k][0];
                int posY = j + dir[k][1];

                if (posX < 0 || posY < 0 || posX >= n || posY >= m || grid[posX][posY] >= 1)
                    continue;

                positionQueue.offer(new Position(posX, posY, position.steps + 1));
                grid[posX][posY] = position.steps + 1;
            }
        }

        return -1;
    }

    static class Position {
        int x;
        int y;
        int steps;

        public Position(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(new Solution().shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,1}}));
    }
}