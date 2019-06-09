package WeeklyContest140.SmallestSubsequenceOfDistinctCharacters;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public String smallestSubsequence(String text) {
        StringBuilder result = new StringBuilder();
        Set<DistinctChar> set = new TreeSet<DistinctChar>(new Comparator<DistinctChar>() {
            @Override
            public int compare(DistinctChar o1, DistinctChar o2) {
                if (o1.repeat == false && o2.repeat == false){
                    return o1.ch.compareTo(o2.ch);
                }else if (o1.repeat == false && o2.repeat == true){
                    return -1;
                }else if (o1.repeat == true && o2.repeat == false){
                    return 1;
                }else if (o1.repeat == true && o2.repeat == true){
                    return o1.ch.compareTo(o2.ch);
                }else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < text.length(); i++) {
            DistinctChar dc1 = new DistinctChar(text.charAt(i) + "",false);
            DistinctChar dc2 = new DistinctChar(text.charAt(i) + "",true);
            if (set.contains(dc1) || set.contains(dc2)){
                set.remove(dc1);
                set.add(dc2);
            }else {
                set.add(dc1);
            }
        }

        for (DistinctChar s : set) {
            result.append(s.ch);
        }
        return result.toString();
    }

    class DistinctChar{
        String ch;
        boolean repeat;

        public DistinctChar(String ch, boolean repeat) {
            this.ch = ch;
            this.repeat = repeat;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.smallestSubsequence("ecbacba");
        System.out.println(result);
    }
    
}