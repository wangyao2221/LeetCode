package bytedance0624;

import java.util.Arrays;

/**
 * 在有序数组中找出某数的位置
 */
public class Question02 {
    public static void main(String[] args) {
        int[] result = findRange(new int[]{1,2,3,4,4,5}, 4);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findRange(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;

        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            System.out.println(middle);
            if (arr[middle] == num) {
                break;
            } else if (arr[middle] > num) {
                high = middle - 1;
            } else if (arr[middle] < num) {
                low = middle + 1;
            }
        }

        int min = middle;
        int max = middle;
        for (int i = middle + 1; i < arr.length; i++) {
            if (arr[i] == num) {
                max = i;
            }
        }

        for (int i = middle - 1; i >= 0; i--) {
            if (arr[i] == num) {
                min = i;
            }
        }

        return new int[]{min, max};
    }
}
