package bytedance0624;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class Question01 {
    public static void main(String[] args) {
        String S = "ADOBEC OD EBANC";
        String T = "ABC";

        System.out.println(containsSubstring("ADOBEC".toCharArray(), "ABC".toCharArray()));
        System.out.println(minSubstring(S, T));
    }

    public static String minSubstring(String s, String t) {
        String[] sArr = s.split(" ");

        char[] tCharArr = t.toCharArray();
        int tLen = t.length();
        String minSubstring = s;
        for (int i = 0; i < sArr.length; i++) {
            char[] sCharArr = sArr[i].toCharArray();
            if (containsSubstring(sCharArr, tCharArr) && sArr[i].length() < minSubstring.length()) {
                minSubstring = sArr[i];
            }
        }

        return minSubstring;
    }

    public static boolean containsSubstring(char[] sCharArr, char[] tCharArr) {
        int sLen = sCharArr.length;
        int tLen = tCharArr.length;

        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            if (tFreq.containsKey(tCharArr[i])) {
                Integer tmp = tFreq.get(tCharArr[i]);
                tFreq.put(tCharArr[i], tmp + 1);
            } else {
                tFreq.put(tCharArr[i], 1);
            }
        }

        int distance = 0;
        int right = 0;

        while (right < sLen) {
            if (!tFreq.containsKey(sCharArr[right])) {
                right++;
                continue;
            }

            if (!sFreq.containsKey(sCharArr[right]) || (sFreq.get(sCharArr[right]) < tFreq.get(sCharArr[right]))) {
                distance++;
            }

            if (!sFreq.containsKey(sCharArr[right])) {
                sFreq.put(sCharArr[right], 1);
            } else {
                Integer tmp = sFreq.get(sCharArr[right]);
                sFreq.put(sCharArr[right], tmp + 1);
            }

            right++;

            if (distance == tLen) return true;
        }

        return false;
    }

    public static boolean containsSubstring_(char[] sCharArr, char[] tCharArr) {
        int sLen = sCharArr.length;
        int tLen = tCharArr.length;

        int[] sFreq = new int[128];
        int[] tFreq = new int[128];

        for (int i = 0; i < tLen; i++) {
            tFreq[tCharArr[i]]++;
        }

        int distance = 0;
        int right = 0;

        while (right < sLen) {
            if (tCharArr[sCharArr[right]] == 0) {
                right++;
                continue;
            }

            if (sFreq[sCharArr[right]] < tFreq[sCharArr[right]]) {
                distance++;
            }

            sFreq[sCharArr[right]]++;
            right++;

            if (distance == tLen) return true;
        }

        return false;
    }
}
