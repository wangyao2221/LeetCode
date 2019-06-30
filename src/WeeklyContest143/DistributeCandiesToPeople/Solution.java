package WeeklyContest143.DistributeCandiesToPeople;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int i = 0;
        int n = 1;
        int[] peopleCondies = new int[num_people];

        while (candies > 0){
            if (candies >= n){
                peopleCondies[i] += n;
                i = (i + 1) % num_people;
                candies -= n;
                n++;
            }else {
                peopleCondies[i] += candies;
                candies = 0;
            }
        }

        return peopleCondies;
    }

    public static void main(String[] args) {
        int[] arr = new Solution().distributeCandies(60,4);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}