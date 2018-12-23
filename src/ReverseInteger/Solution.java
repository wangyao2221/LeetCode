package ReverseInteger;

/*
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (24.37%)
 * Total Accepted:    440.7K
 * Total Submissions: 1.8M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [?231,? 231?? 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        int temp;
        boolean nagetive = false;

        if(x >= 0){
            temp = x;
        }else{
            temp = -x;
            nagetive = true;
        }

        long result = 0;
        for (; temp > 0; temp /= 10) {
            result = result * 10 + temp % 10;
        }

        if(result > Integer.MAX_VALUE){
            return 0;
        }else{
            return nagetive ? (int)-result : (int)result;
        }
    } 

}
