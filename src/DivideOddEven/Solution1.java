package DivideOddEven;

import java.util.Arrays;

/**
 * 不使用辅助数组或集合将数组中的奇数放在左边，将偶数放在右边
 * 遍历找奇数，找到后将前面的数后移，用一个变量标记放好了几个奇数，然后将当前的奇数放在该位置
 */
public class Solution1 {
    public int[] divide(int[] arr) {
        int curIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                int tmp = arr[i];
                for (int j = i; j > curIndex; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[curIndex++] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] result = new Solution1().divide(new int[]{1,6,2,3,3,4});
        System.out.println(Arrays.toString(result));
    }
}
