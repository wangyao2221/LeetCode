package WeeklyContest160.CircularPermutationInBinaryRepresentation;

import java.util.ArrayList;
import java.util.List;

/**
 *  Time Limit Exceeded
 */
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        int max = (int) Math.pow(2, n) - 1;
        boolean[] visit = new boolean[max + 1];

        int currentDepth = 0;
        List<Integer> result = circularPermutation(start ,max, currentDepth, start, visit);

        return result;
    }

    private List<Integer> circularPermutation(int root, int max, int currentDepth, int start, boolean[] visit) {
        List<Integer> result = new ArrayList<>();

        visit[start] = true;
        result.add(start);
        currentDepth++;

        if (currentDepth == max + 1) {
            visit[start] = false;
            currentDepth++;
            double tmp = Math.log(start ^ root) / Math.log(2);

            if ((int) tmp == tmp) {
                return result;
            } else {
                return null;
            }
        }

        for (int i = 0; i <= max; i++) {
            if (start == i) {
                continue;
            }

            double tmp = Math.log(start ^ i) / Math.log(2);

            if (!visit[i] && (int) tmp == tmp) {
                List<Integer> list = circularPermutation(root, max, currentDepth, i, visit);
                if (list != null) {
                    result.addAll(list);
                    return result;
                }
            }
        }

        if (start != root) {
            visit[start] = false;
            currentDepth--;
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(~2 & 6);
        System.out.println(Math.pow(4, 1));
        System.out.println();

        List<Integer> result = new Solution().circularPermutation(4, 1);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}