package LongestPalindromeSubstring;

/**
 * 最大回文子串，均衡
 */
public class Solution190722_3 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int len = 0, tmpLen = 0, center = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = check(s, i, i);
            int len2 = check(s, i, i + 1);
            tmpLen = Math.max(len1, len2);

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

    private int check(String s, int left, int right) {
        int L = left, R = right, len = 0;

        while (L >= 0 && R < s.length()) {
            if (s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
                len += 2;
            } else {
                break;
            }
        }

        if (left != L) {
            L++;
            R--;
        }

        return  left == right ? len - 1 : len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution190722_3().longestPalindrome("cbba"));
        System.out.println(new Solution190722_3().longestPalindrome("babad"));
        System.out.println(new Solution190722_3().longestPalindrome("aba"));
    }
}
