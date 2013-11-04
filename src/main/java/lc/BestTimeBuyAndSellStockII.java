package lc;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author lli003
 *
 */
public class BestTimeBuyAndSellStockII {
  
  /**
   * one-dimension dp
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices){
    if (prices.length < 2)
      return 0;
    
    int[] profits = new int[prices.length];
    int buy = prices[0];
    for (int i = 1; i < prices.length; i++){
      profits[i] = profits[i-1] + Math.max(0, prices[i] - buy);
      buy = prices[i];
    }
    
    return profits[profits.length - 1];
  }

}
