package LeetCode76MinimumWindowSubstring;

public class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        int[] winFreg = new int[128];
        int[] tFreq = new int[128];

        for (int i = 0; i < tCharArr.length; i++) {
            tFreq[tCharArr[i]]++;
        }

        int distance = 0;
        int right = 0;
        int left = 0;
        int minLen = sLen;
        String result = s;
        // [left, right)
        while (right < sLen) {
            if (tFreq[sCharArr[right]] == 0) {
                right++;
                continue;
            }

            if (winFreg[sCharArr[right]] < tFreq[sCharArr[right]]) {
                distance++;
            }

            winFreg[sCharArr[right]]++;
            right++;

            while (distance == tLen) {
                if (right - left < minLen) {
                    minLen = right - left;
                    result = s.substring(left, right);
                }

                if (tFreq[sCharArr[left]] == 0) {
                    left++;
                    continue;
                }

                if (winFreg[sCharArr[left]] == tFreq[sCharArr[left]]) {
                    distance--;
                }
                winFreg[sCharArr[left]]--;
                left++;
            }
        }

        return result;
    }
}