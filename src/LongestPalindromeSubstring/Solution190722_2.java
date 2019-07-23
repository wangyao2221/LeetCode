package LongestPalindromeSubstring;

/**
 * 最大回文子串，空间消耗最小
 */
public class Solution190722_2 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int[] start_end = new int[2];

        for (int i = 0; i < s.length(); i++) {
            int[] start_end_1 = check(s, i, i);
            int[] start_end_2 = check(s, i, i + 1);

            int len = start_end[1] - start_end[0];
            int len1 = start_end_1[1] - start_end_1[0];
            int len2 = start_end_2[1] - start_end_2[0];

            if (len1 > len && len1 >= len2) {
                start_end = start_end_1;
            } else if (len2 > len && len2 > len1){
                start_end = start_end_2;
            }
        }

        return s.substring(start_end[0], start_end[1] + 1);
    }

    private int[] check(String s, int left, int right) {

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return new int[]{++left, --right};
    }

    public static void main(String[] args) {
        System.out.println(new Solution190722_2().longestPalindrome("cbba"));
        System.out.println(new Solution190722_2().longestPalindrome("babad"));
        System.out.println(new Solution190722_2().longestPalindrome("aba"));
    }
}
