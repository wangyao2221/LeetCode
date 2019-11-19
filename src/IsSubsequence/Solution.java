package IsSubsequence;

// TODO 调用indexOf似乎会更快
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if (s.length() > t.length()) return false;

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < t.length()){
                if (s.charAt(i) == t.charAt(j) && i == s.length() - 1) {
                    return true;
                } else if (s.charAt(i) == t.charAt(j)) {
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
    }
}