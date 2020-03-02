package DivideOddEven;

import java.util.Arrays;

/**
 * 快速排序思路
 * 理论上所有排序算法都可以解决该问题
 */
public class Solution2 {
    public int[] divide(int[] arr) {
        help(arr, 0 , arr.length - 1);
        return arr;
    }

    public void help(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            help(arr, 0, index - 1);
            help(arr, index + 1, high);
        }
    }

    public int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];

        while (low < high) {
            while (low < high && arr[high] % 2 == 0) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] % 2 == 1) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = tmp;
        return low;
    }

    public void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] result = new Solution2().divide(new int[]{1,6,2,3,3,4});
        System.out.println(Arrays.toString(result));
    }
}
