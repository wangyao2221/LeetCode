package CourseSchedule;

import java.util.List;

class Solution {
    public static class Graph {
        int val;
        List<Integer> nextList;

        public Graph() {
        }

        public Graph(int val) {
            this.val = val;
        }

        public Graph(int val, List<Integer> nextList) {
            this.val = val;
            this.nextList = nextList;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] finished = new int[numCourses];
        int[] inDegrees = new int[numCourses];

        return false;
    }
}