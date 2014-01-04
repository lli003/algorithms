package lc;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author leili
 *
 */
public class BestTimeBuyAndSellStockIII {

  public int maxProfit(int[] prices) {
    assert (prices != null);
    if (prices.length < 2)
      return 0;

    /* save the max profit in [0,i]. */
    int[] maxToRight = new int[prices.length];
    int low = prices[0];
    int max = 0;
    maxToRight[0] = 0;
    for (int i = 1; i < prices.length; i++) {
      int profit = prices[i] - low;
      if (profit > max)
        max = profit;
      maxToRight[i] = max;
      if (prices[i] < low)
        low = prices[i];
    }

    /* calculate the max profit in [i, n-1], and add it up to with the one of [0, i]. */
    int ret = maxToRight[maxToRight.length - 1];
    int high = prices[prices.length - 1];
    max = 0;
    for (int i = prices.length - 2; i >= 0; i--) {
      int profit = high - prices[i];
      if (profit > max)
        max = profit;
      int finalProfit = max + maxToRight[i];
      if (finalProfit > ret)
        ret = finalProfit;
      if (prices[i] > high)
        high = prices[i];
    }

    return ret;
  }

}
