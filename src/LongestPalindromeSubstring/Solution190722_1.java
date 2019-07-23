package LongestPalindromeSubstring;

/**
 * 最大回文子串，最快
 */
public class Solution190722_1 {
    public String longestPalindrome(String s) {
        // babad
        // cbbd
        if (s.length() == 0) return "";

        int center = 0, len = 0, tmpLen = 0;

        for (int i = 0; i < s.length(); i++) {
            tmpLen = check(s, i);
            if (tmpLen > len) {
                len = tmpLen;
                center = i;
            }
        }

        int start = 0, end = 0;
        if (len % 2 == 0) {
            start = center - (len / 2) + 1;
            end = center + (len / 2);
        } else {
            start = center - (len / 2);
            end = center + (len / 2);
        }

        return s.substring(start, end + 1);
    }

    private int check(String s, int center) {
        int left = center - 1, right = center + 1;
        int len1 = 1;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len1 += 2;
            } else {
                break;
            }
        }

        left = center;
        right = center + 1;
        int len2 = 0;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len2 += 2;
            } else {
                break;
            }
        }

        return len1 > len2 ? len1 : len2;
    }
    public static void main(String[] args) {
        System.out.println(new Solution190722_1().longestPalindrome("cbba"));
        System.out.println(new Solution190722_1().longestPalindrome("babad"));
        System.out.println(new Solution190722_1().longestPalindrome("aba"));
    }
}
