package BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int result = 0,min = prices[0],profit = 0;

        for (int price : prices) {
            if (price > min) {
                profit = price - min;
                if (profit > result) {
                    result = profit;
                }
            } else  {
                min = price;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(input));
    }
}