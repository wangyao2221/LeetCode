package InversePairs;

import java.util.Arrays;

public class Solution {
    public int InversePairs(int [] array) {
        int[] copy = new int[array.length];
        return InversePairs(array, copy, 0, array.length - 1);
    }
    
    public int InversePairs(int[] array, int[] copy, int start, int end) {
        if(start == end) {
            copy[start] = array[start];
            return 0;
        }
        
        int middle = (start + end) / 2;
        
        int left = InversePairs(array, copy, start, middle);
        int right = InversePairs(array, copy, middle + 1, end);
        
        int i = middle, j = end, copyIndex = end;
        int count = 0;
        while(i >= start && j > middle) {
            if(array[i] > array[j]) {
                copy[copyIndex--] = array[i--];
                count += j - middle;
            } else {
                copy[copyIndex--] = array[j--];
            }
        }
        
        while(i >= start) {
            copy[copyIndex--] = array[i--];
        }
        
        while(j > middle) {
            copy[copyIndex--] = array[j--];
        }

        for (int k = start; k <= end; k++) {
            array[k] = copy[k];
        }

        return left + right + count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,2,3,4,5,6,7,0};
//        int[] array = {1, 2, 3, 0};
        System.out.println(solution.InversePairs(array));
    }
}