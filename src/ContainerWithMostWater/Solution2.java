package ContainerWithMostWater;

class Solution2 {
    public int maxArea(int[] height) {
        int max = 0;

        int left = 0, right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                int tmp = left;
                do {
                    left++;
                } while (left < right && height[left] < height[tmp]);
            } else {
                int tmp = right;
                do {
                    right--;
                } while (left < right && height[tmp] > height[right]);
            }

            int tmpCap = calCap(height, left, right);
            max = Math.max(tmpCap, max);
        }

        return max;
    }

    private int calCap(int[] height,int i,int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {2,3};
        System.out.println(new Solution2().maxArea(height));
    }
}