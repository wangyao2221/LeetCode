package SplitAStringInBalancedStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法不符合提议，但也可以出一道题，就是找最大数量的RRLL对称数量
 */
class SolutionNewQuestion {
    public int balancedStringSplit(String s) {
        int result = 0;
        List<Integer> counts = new ArrayList<>();

        char flag = ' ';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != flag) {
                if (flag != ' ') {
                    counts.add(count);
                }
                flag = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        counts.add(count);

//        for (Integer integer : counts) {
//            System.out.println(integer);
//        }

        for (int i = 0; i < counts.size() - 1; i++) {
            int value1 = counts.get(i);
            int value2 = counts.get(i + 1);
            int minCount = Math.min(value1, value2);
            if (minCount > 0) {
                result++;
                counts.set(i, value1 - minCount);
                counts.set(i + 1, value2 - minCount);
            }
        }

        for (Integer integer : counts) {
            System.out.println(integer);
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
//        System.out.println(new Solution().balancedStringSplit("RLLLLRRRLR"));
//        System.out.println(new Solution().balancedStringSplit("LLLLRRRR"));
        System.out.println(new SolutionNewQuestion().balancedStringSplit("RRLRRLRLLLRL"));
    }
}