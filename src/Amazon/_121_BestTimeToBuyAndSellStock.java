package Amazon;

public class _121_BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0], res = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++) {
            res = Math.max(res,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return res < 0? 0 : res;
    }

}
