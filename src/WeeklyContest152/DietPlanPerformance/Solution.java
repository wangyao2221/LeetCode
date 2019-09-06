package WeeklyContest152.DietPlanPerformance;

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int result = 0;
        int day = 1;
        int sum = 0;

        for (int i = 0; i < calories.length; i++) {
            sum += calories[i];
            if (day < k) {
                day++;
            } else if (day == k) {
                if (sum < lower) {
                    result -= 1;
                }

                if (sum > upper) {
                    result += 1;
                }

                sum = 0;
                day = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] calories = {1,2,3,4,5};
        System.out.println(new Solution().dietPlanPerformance(calories,1,3,3));
    }
}