package FindTheDifference;

class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result ^ s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            result = result ^ t.charAt(i);
        }

        return (char) result;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(new Solution().findTheDifference(s, t));
    }
}