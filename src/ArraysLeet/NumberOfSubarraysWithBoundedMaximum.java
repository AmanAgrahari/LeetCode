package ArraysLeet;

public class NumberOfSubarraysWithBoundedMaximum {

	public static void main(String[] args) {

		int arr[] = { 2, 1, 4, 3 };
		int L = 2;
		int R = 3;
		System.out.println(numSubarrayBoundedMax(arr, L, R));
	}

	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
		int i;
		int ans = 0;
		int start = 0;
		for (i = 0; i < A.length; i++) {
			if (A[i] > R) {
				ans += calcuateSubArrayContribution(A, start, i - 1, L);
				start = i + 1;
			} else if(i+1 == A.length) {
				ans += calcuateSubArrayContribution(A, start, i, L);
			}
		}
		return ans;
	}

	private static int calcuateSubArrayContribution(int[] a, int start, int end, int L) {

		int i;
		int ans = ((end - start + 1) * (end - start + 2)) / 2;
		int c = 0;
		for (i = start; i <= end; i++) {
			if (a[i] < L) {
				c++;
			} else {
				ans -= ((c) * (c + 1)) / 2;
				c = 0;
			}
			if (i == end) {
				ans -= ((c) * (c + 1)) / 2;
			}
		}
		return ans;
	}

}
