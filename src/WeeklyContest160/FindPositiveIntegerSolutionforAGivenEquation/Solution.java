package WeeklyContest160.FindPositiveIntegerSolutionforAGivenEquation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x = 1, y = 1;

        for (x = 1; x <= z; x++) {
            for (y = 1; customfunction.f(x, y) <= z; y++) {
                if (customfunction.f(x, y) == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    result.add(list);
                }
            }
        }

        return result;
    }

    class CustomFunction {
        public int f(int x, int y) {
             return x + y;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.findSolution(solution.new CustomFunction(), 5);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println();
        }
    }
}