package WeeklyContest140.LetterTilePossibilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private static List<String[]> orders = new ArrayList<>();
    private Set<String> result = new HashSet<>();

    public int numTilePossibilities(String tiles) {
//        if (tiles.length() == 1) return 1;
        String[] arr = tiles.split("");
        permutate(arr,0);
        return count(orders);
    }

    void permutate(String[] origin, int begin) {
        int length = origin.length;
        if (begin == length) {
            String[] order = origin.clone();
            orders.add(order);
        }

        for (int i = begin; i < length; i++) {
            swap(origin, begin, i);
            permutate(origin, begin + 1);
            swap(origin, begin, i);
        }
    }

    void swap(String[] data, int left, int right) {
        String tmp = data[left];
        data[left] = data[right];
        data[right] = tmp;
    }

    int count(List<String[]> orders){
        for (int i = 0; i < orders.size(); i++) {
            String[] str = orders.get(i);
            for (int j = 0; j < str.length; j++) {
                for (int k = 0; k + j < str.length; k++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int l = k; l <= k + j; l++) {
                        stringBuilder.append(str[l]);
                    }
                    result.add(stringBuilder.toString());
                }
            }
        }
        result.remove("");
        return result.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTilePossibilities("V"));
        for (String s : solution.result) {
            System.out.println(s);
        }
    }
}