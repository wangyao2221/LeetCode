package SplitAStringInBalancedStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法不符合提议，但也可以出一道题，就是找最大数量的RRLL对称数量
 */
class Solution {
    public int balancedStringSplit(String s) {
        int result = 0;
        int flag = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'R') {
                flag++;
            } else {
                flag--;
            }

            if (flag == 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
//        System.out.println(new Solution().balancedStringSplit("RLLLLRRRLR"));
//        System.out.println(new Solution().balancedStringSplit("LLLLRRRR"));
        System.out.println(new Solution().balancedStringSplit("RRLRRLRLLLRL"));
    }
}