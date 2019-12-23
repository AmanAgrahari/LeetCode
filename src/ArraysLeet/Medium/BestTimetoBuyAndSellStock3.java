package ArraysLeet.Medium;

public class BestTimetoBuyAndSellStock3 {

	public static void main(String[] args) {

		//int arr[] = {3,3,5,0,0,3,1,4};
		//System.out.println(maxProfit(arr));
	}

	public static  int maxProfit(int[] arr) {
		
		/*
		 *
		 dp[i][j] = Math.max(dp[i][j-1],
		 				price[j] - for all p[k]+ dp[i-1][k-1]);
		 */
		
		if(arr.length < 2) {
			return 0;
		}
		int t = 2;
		int n = arr.length;
		int dp[][] = new int[t+1][n];
		
		for(int i = 1; i <= t; i++) {
			int money = - arr[0];
			for(int j = 1; j < n; j++) {
				money = Math.max(money, -arr[j]+ dp[i-1][j-1]);
				dp[i][j] += Math.max(dp[i][j-1], arr[j]+ money);
			}
			
		}
		return dp[t][n-1];
	}
	
	public static  int maxProfit1(int[] arr, int k) {
		int tmax = k, size = arr.length;
        if(size < 2) return 0;
        
        int dp[] = new int[k+1];
		int maxMoney[] = new int[size+1];
        
        for(int j = 1; j < size; ++j) {
            for(int i = tmax; i >= 1; --i) {
                maxMoney[i] =  Math.max(maxMoney[i], -arr[j] + dp[i-1]);
                dp[i] =  Math.max(dp[i], arr[j] + maxMoney[i]);
            }
        }   
        return dp[tmax];
	}
}
