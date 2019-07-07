package WeeklyContest144.CorporateFlightBookings;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                result[j - 1] += bookings[i][2];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{5,6,45},{5,6,5},{1,6,10},{5,6,5},{1,2,15},{1,2,5}};
        System.out.println(new Solution().corpFlightBookings(input, 6));

    }
}