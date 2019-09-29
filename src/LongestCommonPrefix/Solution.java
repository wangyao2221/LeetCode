package LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        int longestCommonLen = 0;
        int flag = 0;

        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                break;
            }

            longestCommonLen++;
        }

        return strs[0].substring(0, longestCommonLen);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}