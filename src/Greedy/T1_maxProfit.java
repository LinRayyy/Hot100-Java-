package Greedy;

public class T1_maxProfit {
    /*
        如果当天的价格比minPrice小，则存入minPrice
        否则计算最大值
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else{
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }
}
