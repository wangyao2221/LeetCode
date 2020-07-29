package LeetCode5448;

import java.util.*;

class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Map<String, Boolean> flag = new HashMap<>();
        char[] pathArr = path.toCharArray();
        flag.put(0 + "," + 0, true);
        for (int i = 0; i < pathArr.length; i++) {
            if (pathArr[i] == 'N') {
                y += 1;
            } else if (pathArr[i] == 'S') {
                y -= 1;
            } else if (pathArr[i] == 'E') {
                x += 1;
            } else {
                x -= 1;
            }

            if (flag.containsKey(x + "," + y)) {
                return true;
            } else {
                flag.put(x + "," + y, true);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isPathCrossing("SN"));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 4}, 3, 4, 4));
    }


}