package ForOffer.MaxInWindows;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Integer> dequeue = new LinkedList<Integer>();
        // 初始化第一个窗口
        // i不到size - 1是因为第size - 1个需要在窗口开始滑动时才开始往结果集里加入数据
        for(int i = 0; i < size - 1; i++) {
            while(!dequeue.isEmpty() && num[i] < num[dequeue.getLast()]) {
                dequeue.removeLast();
            }
            dequeue.add(i); // 存下标，因为后面要判断最大数是否出窗口，出口需要用下标来判断
            // result.add(dequeue.getFirst());  第size - 1个需要在窗口开始滑动时才开始往结果集里加入数据
        }

        for(int i = size - 1; i < num.length; i++) {
            // dequeue所有比num[i]小的元素都删除后，dequeue.getLast就是比num[i]大的值
            while(!dequeue.isEmpty() && num[i] < num[dequeue.getLast()]) {
                dequeue.removeLast();
            }
            dequeue.add(i); // 因为窗口内的数字逗比num[i]小，因此需要先将i add进去才有最大值(getFirst才能获取到值)
            int index = dequeue.getFirst(); // 最大值
            // 如果最大值不在窗口内了则将其从dequeue中移除
            if(i - index >= size) {
                dequeue.removeFirst();
            }
            result.add(dequeue.getFirst());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        Solution solution = new Solution();
        solution.maxInWindows(num, size);
    }
}