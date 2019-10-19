package ContainerWithMostWater;

/**
 * 每次循环从高度更小的一侧开始找，因为容量是由高度小的一侧决定的
 * 从高度大的一侧找无论怎么找都不可能让容量更大
 * 下面left右移，right左移不用恢复的原因也是上面这个原因，高度大的一侧移动不可能让容量增大
 */
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