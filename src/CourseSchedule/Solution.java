package CourseSchedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int finished = 0;
        int[] inDegrees = new int[numCourses];

        // 用map构造有向图
        for (int i = 0; i < prerequisites.length; i++) {
            int in = prerequisites[i][0];
            int out = prerequisites[i][1];
            if (!map.containsKey(in)) {
                map.put(in, new ArrayList<Integer>());
            }
            map.get(in).add(out);
            // 计算入度
            inDegrees[out]++;
        }

        // 找出第一轮入度为1的课程
        Queue<Integer> zeroInQueue = new LinkedList<Integer>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                zeroInQueue.offer(i);
            }
        }

        // 用拓扑排序的方法计算可完成的课程
        while (!zeroInQueue.isEmpty()) {
            int course = zeroInQueue.poll();
            finished++;
            List<Integer> nextCourses = map.get(course);
            if (nextCourses != null) {
                for (Integer nextCourse : nextCourses) {
                    if (inDegrees[nextCourse] != 0) {
                        inDegrees[nextCourse]--;
                        if (inDegrees[nextCourse] == 0) {
                            zeroInQueue.offer(nextCourse);
                        }
                    }
                }
            }
        }

        return finished == numCourses;
    }
}