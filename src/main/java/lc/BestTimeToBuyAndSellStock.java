package lc;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author lli003
 *
 */
public class BestTimeToBuyAndSellStock {
  
  public int maxProfit(int[] prices){
    if (prices.length < 2)
      return 0;
    
    int min = prices[0], maxProfit = 0;
    for (int i = 1; i < prices.length; i++){
      if (prices[i] < min)
        min = prices[i];
      else {
        int profit = prices[i] - min;
        if (profit > maxProfit)
          maxProfit = profit;
      }
    }
    return maxProfit;
  }

}
