package AddingTwoNegabinaryNumbers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int num1 = 0;
        int num2 = 0;
        for (int i = arr1.length - 1; i >= 0; i--) {
            num1 += Math.pow(-2,i) * arr1[arr1.length - 1 - i];
        }

        for (int i = arr2.length - 1; i >= 0; i--) {
            num2 += Math.pow(-2,i) * arr2[arr2.length - 1 - i];
        }

        return decimal2binary(Math.abs(num1 + num2));
    }

    public int[] decimal2binary(int decimal){
        if (decimal == 0) {
            return new int[]{0};
        }

        List<Integer> binaryList = new ArrayList<>();
        int d = decimal;

        while (d > 0){
            binaryList.add(d % 2);
            d /= 2;
        }

        int binaryListSize = binaryList.size();
        int[] result = new int[binaryList.size()];

        for (int i = 0; i < binaryListSize; i++) {
            result[i] = binaryList.get(binaryListSize - i - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {0};
        int[] arr2 = {1,0};

        int[] result = new Solution().addNegabinary(arr1,arr2);

        for (int i : result) {
            System.out.println(i);
        }
    }
}