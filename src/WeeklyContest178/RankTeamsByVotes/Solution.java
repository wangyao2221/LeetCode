package WeeklyContest178.RankTeamsByVotes;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String rankTeams(String[] votes) {
        int personNum = votes[0].length();
        String result = "";
        int[][] votes_ = new int[27][27];

        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[0].length(); j++) {
                if (votes_[votes[i].charAt(j) - 'A'][0] == 0) {
                    votes_[votes[i].charAt(j) - 'A'][0] = votes[i].charAt(j);
                }
                votes_[votes[i].charAt(j) - 'A'][j + 1] = votes_[votes[i].charAt(j) - 'A'][j + 1] + 1;
            }
        }

        Arrays.sort(votes_, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 1; i < o1.length; i++) {
                    if (o1[i] == o2[i]) {
                        continue;
                    } else if (o1[i] < o2[i]) {
                        return 1;
                    } else if (o1[i] > o2[i]) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        for (int i = 0; i < votes_.length; i++) {
            if (votes_[i][0] != 0) {
                result += (char)votes_[i][0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String[] input = {"ABC",
//                        "ACB",
//                        "ABC",
//                        "ACB",
//                        "ACB"};
        String[] input = {"WXYZ","XYZW"};
        System.out.println(new Solution().rankTeams(input));
    }
}