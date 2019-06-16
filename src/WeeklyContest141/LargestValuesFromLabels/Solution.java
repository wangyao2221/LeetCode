package WeeklyContest141.LargestValuesFromLabels;

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int max = -1;
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] > max) {
                max = labels[i];
            }
        }
        int[] count = new int[max + 1];

        quickSort(values, labels, 0, values.length - 1);

        int sum = 0;
        for (int i = 0; i < values.length && num_wanted > 0; i++) {
            int label = labels[i];

            if (count[label] < use_limit){
                sum += values[i];
                count[label]++;
                num_wanted--;
            }
        }

        return sum;
    }

    public void quickSort(int[] values, int[] labels, int low, int high) {
        if (low < high) {
            int povit = partition(values, labels, low, high);
            quickSort(values, labels, low, povit - 1);
            quickSort(values, labels, povit + 1, high);
        }
    }

    public int partition(int[] values, int[] labels, int low, int high) {
        int povit_value = values[low];
        int povit_label = labels[low];

        while (low < high) {
            while (low < high && values[high] <= povit_value) {
                high--;
            }
            values[low] = values[high];
            labels[low] = labels[high];

            while (low < high && values[low] >= povit_value) {
                low++;
            }
            values[high] = values[low];
            labels[high] = labels[low];
        }

        values[low] = povit_value;
        labels[low] = povit_label;

        return low;
    }

    public static void main(String[] args) {
        int[] values = {5, 4, 3, 2, 1}, labels = {1, 3, 3, 3, 2};
        int num_wanted = 3, use_limit = 2;
        System.out.println(new Solution().largestValsFromLabels(values, labels, num_wanted, use_limit));
    }
}