package WeeklyContest140.OccurrencesAfterBigram;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(first) && i + 1 < arr.length && arr[i + 1].equals(second)){
                if (i + 2 < arr.length) resultList.add(arr[i + 2]);
            }
        }
        String[] result = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] result = new Solution().findOcurrences(text,first,second);
        for (String s : result) {
            System.out.println(s);
        }
    }
}