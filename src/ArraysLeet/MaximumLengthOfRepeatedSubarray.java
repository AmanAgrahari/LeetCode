package ArraysLeet;

public class MaximumLengthOfRepeatedSubarray {
	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 2, 1 };
		int B[] = { 3, 2, 1, 4, 7 };

		int a[] = { 1 };
		int b[] = { 1 };

		System.out.println(findLength(A, B));
	}

	
	public static int findLengthOpt(int[] A, int[] B) {
	
		int low = 0;
		int high = A.length;
		int ans  = 0;
		while(low <= high) {
			int mid = (low+high)/2;
			if(query(mid,A,B)) {
				ans = mid;
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return ans;
	}
	
	private static boolean query(int mid, int[] a, int[] b) {
	
		
		return false;
	}	
	
	public static int findLength(int[] A, int[] B) {
		int max = 0;
		int dp[][] = new int[A.length][B.length];
		int i, j;

		for (i = 0; i < A.length; i++) {
			for (j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					dp[i][j] = (i - 1 >= 0 && j - 1 >= 0)? (1 + dp[i - 1][j - 1]): 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}
		for (i = 0; i < A.length; i++) {
			for (j = 0; j < B.length; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
