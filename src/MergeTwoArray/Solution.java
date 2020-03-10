package MergeTwoArray;

/**
 * @author wangyao2221
 */
public class Solution {
    public static int[] result;
    public static int index = 0;
    public static int[] merge(int[] a, int[] b) {
        result = new int[a.length + b.length];
        help(a, b, 0, 0);
        for (int i : result) {
            System.out.println(i);
        }
        return result;
    }

    public static void help(int[] a, int[] b, int aIndex, int bIndex) {
        if (aIndex == a.length) {
            for (int i = bIndex; i < b.length; i++) {
                result[index++] = b[bIndex++];
            }
            return;
        }

        if (bIndex == b.length) {
            for (int i = aIndex; i < a.length; i++) {
                result[index++] = a[aIndex++];
            }
            return;
        }

        if (a[aIndex] < b[bIndex]) {
            result[index++] = a[aIndex];
            help(a, b, aIndex + 1, bIndex);
        } else {
            result[index++] = b[bIndex];
            help(a, b, aIndex, bIndex + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        Solution.merge(a, b);
    }
}
