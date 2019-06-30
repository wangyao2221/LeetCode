package WeeklyContest143.PathInZigzagLabelledBinaryTree;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<Integer> result = new Solution().pathInZigZagTree(14);
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<Integer>();
        int high = high(label);

        int[] labelArr = new int[(int) (Math.pow(2,high) - 1)];
        for (int i = 0; i < labelArr.length; i++) {
            labelArr[i] = i + 1;
        }

        int n = 0;
        for (int i = 0; i <= labelArr.length / 2;i = i * 2 + 1,n++) {
            if (n % 2 == 1){
                quickSort(labelArr,i,i * 2);
            }
        }

        int index = 0;
        for (int i = 0; i < labelArr.length; i++) {
            if (labelArr[i] == label) {
                index = i;
            }
        }

        while (index >= 0){
            result.add(0,labelArr[index]);
            if (index == 0){
                break;
            }
            if (index % 2 == 0){
                index = (index - 2) / 2;
            }else {
                index = index / 2;
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
            while (low < high && arr[high] <= povit) {
                high--;
            }

            arr[low] = arr[high];
            while (low < high && arr[low] >= povit) {
                low++;
            }

            arr[high] = arr[low];
        }

        arr[low] = povit;
        return low;
    }

    private int high(int label){
        int high = 0;
        int i = 0;

        while (i < label){
            high++;
            i = i * 2 + 1;
        }

        return high;
    }
}