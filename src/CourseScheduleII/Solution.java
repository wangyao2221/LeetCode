package CourseScheduleII;

import java.util.*;

/**
 * 发现一个问题，将图中有向边换个方向，在进行拓扑排序检测结果是一样的
 * 也就是说是一个对偶问题？
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int finished = 0;
        int[] result = new int[numCourses];
        int[] inDegrees = new int[numCourses];

        // 用map构造有向图
        for (int i = 0; i < prerequisites.length; i++) {
            int out = prerequisites[i][0];
            int in = prerequisites[i][1];
            if (!map.containsKey(in)) {
                map.put(in, new ArrayList<Integer>());
            }
            map.get(in).add(out);
            // 计算入度
            inDegrees[out]++;
        }

        // 找出第一轮入度为0的课程
        Queue<Integer> zeroInQueue = new LinkedList<Integer>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                zeroInQueue.offer(i);
            }
        }

        int count = 0;
        // 用拓扑排序的方法计算可完成的课程
        while (!zeroInQueue.isEmpty()) {
            int course = zeroInQueue.poll();
            finished++;
            result[count++] = course;
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

        if (finished == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}