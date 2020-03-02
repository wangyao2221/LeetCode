package DivideOddEven;

public class Solution {
    public int[] divide(int[] arr) {
        return help(arr, 0, arr.length - 1);
    }

    public int[] help(int[] arr, int left, int right) {
        int[] result = new int[right - left + 1];

        if (right - left == 1 && left % 2 == 0 && right % 2 == 1) {
//            swap(arr, left, right);
            result[0] = arr[left];
            return result;
        }

        int middle = (left - right + 1) / 2;
        int[] leftArr = help(arr, left, middle);
        int[] rightArr = help(arr, middle + 1, right);

        int i = 0;
        int k = 0;
        for (; i < leftArr.length; i++) {
            if (leftArr[i] % 2 == 0) {
                break;
            }
            result[k++] = leftArr[i];
        }

        for (int j = 0; j < rightArr.length; j++) {
            result[k++] = leftArr[j];
        }

        for (; i < rightArr.length; i++) {
            result[k++] = leftArr[i];
        }

        return result;
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
//        System.out.println(arr[i] + " " + arr[j]);
    }

    public static void main(String[] args) {
//        new Solution().swap(new int[]{1, 2}, 0 , 1);
    }
}
