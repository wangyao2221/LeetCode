package RemoveAllAdjacentDuplicatesInString;

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);

        for (int i = 0; i < sb.length(); ) {
            if (i + 1 < sb.length() && i >= 0 && sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i);
                i--;
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("aaabbb"));
    }
}