package ContainerWithMostWater;

// TODO 还没通过
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 2; j < height.length; j++) {
                int sum = 0;
                int min = height[i] < height[j] ? height[i] : height[j];

                for (int k = i; k <= j; k++) {
                    if (height[k] <= min) {
                        sum += height[k];
                    } else {
                        sum += min;
                    }
                }

                sum += min;

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(height));
    }
}