package WeeklyContest153.DistanceBetweenBusStops;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int distanceSum = 0;

        for (int i = 0; i < distance.length; i++) {
            distanceSum += distance[i];
        }

        int distance1 = 0;
        int distance2 = 0;

        for (int i = start; i < destination; i++) {
            distance1 += distance[i];
        }

        distance2 = distanceSum - distance1;

        return distance1 < distance2 ? distance1 : distance2;
    }

    public static void main(String[] args) {
        int[] distance = {1,2,3,4};
        System.out.println(new Solution().distanceBetweenBusStops(distance,0,3));
    }
}