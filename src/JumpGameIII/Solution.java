package JumpGameIII;

/**
 * 思路：
 * 1、首先构建一个下标到下标之间的可达性的图
 * 2、从start出发DFS搜索是否有可达0所在位置的路径
 */
class Solution {
    public boolean canReach(int[] arr, int start) {
//        int[][] graph = new int[arr.length][2]; 这一行初始化竟会导致运行时间增加8ms
        boolean[] visit = new boolean[arr.length];

        return dfs(arr, start, visit);
    }

    public boolean dfs(int[] arr, int start, boolean[] visit) {
        if (start < 0 || start >= arr.length || visit[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }

        int jump = arr[start];
        visit[start] = true;
        //        visit[start] = false; 不需要，这条路径经过了该点，也就表明经过该点的路径都不会到到值为0的位置

        return dfs(arr, start - jump,  visit) || dfs(arr, start + jump, visit);
    }
}