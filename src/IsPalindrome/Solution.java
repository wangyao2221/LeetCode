package IsPalindrome;

/*
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (38.72%)
 * Total Accepted:    405.5K
 * Total Submissions: 1M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer?is?a?palindrome
 * when it?reads the same backward as forward.
 * 
 * Example 1:
 * 
 * 
 * Input: 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Follow up:
 * 
 * Coud you solve?it without converting the integer to a string?
 * 
 */
class Solution {
    public boolean isPalindrome_(int x) {
        String xString = String.valueOf(x);
        String xStringReverse = new StringBuilder(xString).reverse().toString();
        if(xString.equals(xStringReverse)){
            return true;
        }
        return false;
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String xString = String.valueOf(x);
        int pre = 0,suf = xString.length() - 1;
        while(pre < suf){
            if(xString.charAt(pre) != xString.charAt(suf)){
                return false;
            }
            pre++;
            suf--;
        }
        
        return true;
    }
}
