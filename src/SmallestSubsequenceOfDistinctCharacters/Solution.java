package SmallestSubsequenceOfDistinctCharacters;

import java.util.Stack;

class Solution {
    public String smallestSubsequence(String text) {
        int[] maxIndexes = new int[26];
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            maxIndexes[ch - 'a'] = i;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!used[ch - 'a']){
                while (!stack.empty()){
                    char tmpCh = stack.peek(); // 取出末尾字符，不出栈
                    if (maxIndexes[tmpCh - 'a'] > i && ch < tmpCh){
                        stack.pop(); // 末尾字符出栈
                        used[tmpCh - 'a'] = false;
                    }else {
                        break;
                    }
                }
                stack.push(ch);
                used[ch - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestSubsequence("leetcode"));
    }
}