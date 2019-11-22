package BestTimeToBuyAndSellStockII;

// TODO 自己写的这个算法有些妙，后面再思考一下

/**
 * 每次找到降序的位置就是计算一次收益
 * 每计算了一次收益就将所有坐标定位到下一个下标，相当于重新计算一组收益，因此每一次计算收益的最小值就是这一组收益的第一个数
 * 如果到最后都没有降序说明最大收益是最后一个值减第一个值
 */
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minIndex = 0;
        int maxIndex = 0;
        int tmpIndex = 1;

        while (true) {
            if (tmpIndex >= prices.length) break;

            if (prices[tmpIndex] <= prices[maxIndex]) {
                result += prices[maxIndex] - prices[minIndex];
                minIndex = tmpIndex;
                maxIndex = tmpIndex;
                tmpIndex++;
            } else {
                if (tmpIndex == prices.length - 1) {
                    result = prices[tmpIndex] - prices[minIndex];
                } else {
                    maxIndex = tmpIndex;
                }
                tmpIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5}));
    }
}