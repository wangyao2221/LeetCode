package LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max_len = 0;

        if (s.length() == 1) return 1;

        for (int i = 1; i < s.length(); i++) {
            int temp = -1;

            int index = s.substring(start, i).indexOf(s.charAt(i));
            if (index > -1) {
                temp = i - start;
                start = start + index + 1;
            } else if (i == s.length() - 1) {
                temp = i - start + 1;
            }

            if (temp > max_len) max_len = temp;
        }

        return max_len;
    }
}