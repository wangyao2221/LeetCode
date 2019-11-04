package WeeklyContest161.MinimumSwapsToMakeStringsEqual;

import java.util.Arrays;


class Solution {
    // TODO 看讨论
    public int minimumSwap(String s1, String s2) {
        int result = 0;

        int length = s1.length();
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];

        for (int i = 0; i < length; i++) {
            arr1[i] = s1.charAt(i) - 'x';
            arr2[i] = s2.charAt(i) - 'x';
        }

        for (int i = 0; i < length - 1; i++) {
            if (arr1[i] != arr2[i] && arr1[i] == arr2[i + 1] && arr1[i + 1] == arr2[i]) {
                swap(arr1, arr2, i, i);
                swap(arr1, arr2, i, i + 1);
                result += 2;
            } else if (arr1[i] != arr2[i] && arr1[i] == arr1[i + 1]) {
                swap(arr1, arr2, i, i + 1);
                result++;
            } else if (true) {

            } else if (true) {

            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                return -1;
            }
        }

        return result;
    }

    private void swap(int[] arr1, int[] arr2, int index1,int index2) {
        int num1 = arr1[index1];
        int num2 = arr2[index2];
        arr1[index1] = num2;
        arr2[index2] = num1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSwap("xx", "yy"));
        System.out.println(new Solution().minimumSwap("xy", "yx"));
        System.out.println(new Solution().minimumSwap("xx", "yx"));
        System.out.println(new Solution().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}