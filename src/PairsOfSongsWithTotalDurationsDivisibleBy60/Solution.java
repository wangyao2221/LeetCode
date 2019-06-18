package PairsOfSongsWithTotalDurationsDivisibleBy60;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        int[] occured = new int[60];

        for(int i = 0;i < time.length;i++){
            time[i] %= 60;
            int index = time[i] == 0 ? 0 : 60 - time[i];
            result += occured[index];
            occured[time[i]]++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};
        System.out.println(new Solution().numPairsDivisibleBy60(time));
    }
}