package test.netease;

/**
 * @author wangyao2221
 * @date 2020/7/21 20:11
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{2,4}, {1,4}, {0,3}, {0,3}};
        System.out.println(solution.fun(5 ,arr));
    }

    public int fun(int n, int[][] arr) {
        int[] seq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            swap(seq, arr[i][0], arr[i][1]);
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (seq[i] < seq[j]) count++;
            }
        }

        if (count % 2 == 0) return 2;
        else return 1;
    }

    public void swap(int[] seq, int i, int j) {
        int tmp = seq[i];
        seq[i] = seq[j];
        seq[j] = tmp;
    }
}
