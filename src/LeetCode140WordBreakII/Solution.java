package LeetCode140WordBreakII;

import java.util.*;

class Solution {
    List<String> result = new ArrayList<String>();
    boolean[] cantBreak;

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> map = new HashSet<String>();
        cantBreak = new boolean[s.length()];

        for (int i = 0; i < wordDict.size(); i++) {
            map.add(wordDict.get(i));
        }

        help(s, 0, map, "");

        return result;
    }

    public void help(String s, int start, Set<String> wordDict, String rs) {
        if (start == s.length()) {
            result.add(rs);
            return;
        }

        int rsSize = result.size();

        if (!cantBreak[start]) {
            for (int i = start; i < s.length(); i++) {
                String tmp = s.substring(start, i + 1);
                if (wordDict.contains(tmp)) {
                    if ("".equals(rs)) {
                        help(s, i + 1, wordDict, rs + tmp);
                    } else {
                        help(s, i + 1, wordDict, rs + " " + tmp);
                    }
                }
            }
        }

        if (result.size() <= rsSize) cantBreak[start] = true;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> dict = Arrays.asList(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"});
        new Solution().wordBreak(s, dict);
    }
}