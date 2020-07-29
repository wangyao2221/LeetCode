package test.bytedance;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO 非0子数组
 *
 * @author wangyao2221
 * @date 2020/7/25 10:37
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(new Main3().help(new int[]{1, 2, -3}));
    }

    public int help(int[] arr) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            PriorityQueue<Integer> tmpQueue = new PriorityQueue<>();
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int sum = queue.peek();
                if (sum + arr[i] > 0) tmpQueue.add(sum);
            }

            if (arr[i] != 0) count++;

        }
        return count;
    }

    public int help1(int[] arr) {
        int count = 0;

        return count;
    }

    public int help(int[] arr, int i, int curResult) {
        if (i >= arr.length) return 0;

        int result = 0;

        curResult += arr[i];
        if (curResult != 0) result++;
        result += help(arr, i + 1, curResult);
        result += help(arr, i + 1, 0);

        return result;
    }
}
