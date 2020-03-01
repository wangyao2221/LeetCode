package WeeklyContest178.HowManyNumbersAreSmallerThanTheCurrentNumber;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length;i++) {
            for(int j = 0;j < nums.length;j++) {
                if(i != j && nums[i] > nums[j]) {
                    count[i]++;
                }
            }
        }
        return count;
    }
}