package WeeklyContest145.RelativeSortArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = new Solution().relativeSortArray(arr1, arr2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }

        int j = arr1.length - 1;
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i])) result[j--] = arr1[i];
            if (map.containsKey(arr1[i])) {
                int key = arr1[i];
                int value = map.get(key);
                map.put(key, ++value);
            }
        }

        quickSort(result, j + 1, result.length - 1);

        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int l = 0; l < map.get(arr2[i]); l++) {
                result[k++] = arr2[i];
            }
        }

        return result;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int povit = partition(arr, low, high);
            quickSort(arr, low, povit - 1);
            quickSort(arr, povit + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int povit = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= povit) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= povit) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = povit;
        return low;
    }
}