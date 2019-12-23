package ArraysLeet.Medium;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BestTimeToBuyAndSellTheStockWithTransactionFees {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 2, 8, 4, 9 };
		System.out.println(maxProfit(arr, 2));

	}

	public static int maxProfit(int[] prices, int fee) {

		if(prices == null || prices.length == 0) {
			return 0;
		}
		
		int dpSell[] = new int[prices.length];
		int dpPurchase[] = new int[prices.length];
		dpSell[0] = 0;
		dpPurchase[0] = -prices[0];
		int i;
		for (i = 1; i < prices.length; i++) {
			dpSell[i] = Math.max(dpPurchase[i - 1] + prices[i] - fee, dpSell[i - 1]);
			dpPurchase[i] = Math.max(dpSell[i - 1] - prices[i], dpPurchase[i - 1]);
		}
		return dpSell[prices.length-1];
	}
}
