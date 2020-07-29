package LeetCode5435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[] inDegree = new int[n + 1];

        for(int i = 0; i < dependencies.length; i++) {
            inDegree[dependencies[i][1]]++;
        }

        Queue<Integer> courseQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                courseQueue.offer(i);
            }
        }

        int result = 0;
        boolean[] visit = new boolean[n + 1];
        int currentSize = courseQueue.size();
        while (!courseQueue.isEmpty()) {
            int newSize = 0;
            for (int i = 0; i < currentSize; i++) {
                Integer course = courseQueue.poll();
                visit[course] = true;
                for (int j = 0; j < dependencies.length; j++) {
                    if (course == dependencies[j][0] && visit[dependencies[j][1]] == false) {
                        courseQueue.offer(dependencies[j][1]);
                        newSize++;
                    }
                }
            }
            currentSize = newSize;
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.minNumberOfSemesters(4, new int[][]{
//                {2, 1},
//                {3, 1},
//                {1, 4}
//        }, 2));
        String str = "TDAA202036040000213355|DAA|||||||36||2|83604326|2020-06-27|||2020-06-27 17:51:31|2020-06-27 17:51:31|1|47100.0|622000.0|1225.5|2859.49|393.44||||||";
        System.out.println(str.split("\\|").length);
        System.out.println(str.split("\\|")[1]);
    }
}