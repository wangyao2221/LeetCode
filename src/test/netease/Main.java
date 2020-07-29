package test.netease;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wangyao2221
 * @date 2020/7/21 19:36
 */
public class Main {
    public int[][] inverse_tree(int[][] node_data_list) {
        int len = node_data_list.length;
        int[][] result = new int[len][2];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int i = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (right < len) {
                queue.add(right);
                result[i++] = node_data_list[right];
            }

            if (left < len) {
                queue.add(left);
                result[i++] = node_data_list[left];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {2, 1}, {3, 1}};
        Main main = new Main();
        int[][] result = main.inverse_tree(arr);
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result[i].length; i1++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
