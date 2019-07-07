package RemoveAllAdjacentDuplicatesInString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();

        List<Character> sList = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            sList.add(S.charAt(i));
        }

        for (int i = 0; i < sList.size(); ) {
            if (i + 1 < sList.size() && i >= 0 && sList.get(i) == sList.get(i + 1)) {
                sList.remove(i + 1);
                sList.remove(i);
                i--;
            } else {
                i++;
            }
        }

        for (int i = 0; i < sList.size(); i++) {
            sb.append(sList.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("aaabb"));
    }
}