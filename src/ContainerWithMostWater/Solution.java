package ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            int higher = 0;

            for (int j = height.length - 1; j > i; j--) {
                if (height[j] <= higher) {
                    continue;
                }

                int sum = 0;
                int min = height[i] < height[j] ? height[i] : height[j];

                sum = min * (j - i);

                if (sum > max) {
                    max = sum;
                }

                higher = height[j];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {2,3};
        System.out.println(new Solution().maxArea(height));
    }
}