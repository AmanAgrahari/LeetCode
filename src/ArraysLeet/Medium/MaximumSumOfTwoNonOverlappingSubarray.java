package ArraysLeet.Medium;

public class MaximumSumOfTwoNonOverlappingSubarray {

	public static void main(String[] args) {

		int arr[] = { 1,0,1};
		int L = 1;
		int M = 1;
		maxSumTwoNoOverlap(arr, L, M);
	}

	public static int maxSumTwoNoOverlap(int[] A, int L, int M) {

		int i;
		int left[] = calculateLeftSum1(A, L);
		printArray(left);
		int right[] = calculateRightSum1(A, M);
		printArray(right);
		int maxSum = 0;
		for (i = L - 1; i + M - 1 < A.length; i++) {
			maxSum = Math.max(maxSum, left[i] + right[i + 1]);
		}
		int left1[] = calculateLeftSum1(A, M);
		printArray(left1);
		int right1[] = calculateRightSum1(A, L);
		printArray(right1);
		int maxSum1 = 0;
		for (i = M - 1; i + L - 1 < A.length; i++) {
			if (i + 1 < A.length)
				maxSum1 = Math.max(maxSum1, left1[i] + right1[i + 1]);
		}
		return Math.max(maxSum, maxSum1);
	}

	public static int[] calculateRightSum1(int A[], int M) {
		int i;
		int rightSum = 0;
		int right[] = new int[A.length];
		for (i = 0; i < M; i++) {
			rightSum += A[A.length - 1 - i];
			right[A.length - 1 - i] = 0;
		}
		right[right.length - i] = rightSum;

		for (i = right.length - 1 - M; i >= 0; i--) {
			right[i] = right[i + 1] + A[i] - A[i + M];
		}

		for (i = right.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i], right[i + 1]);
		}
		return right;
	}

	public static int[] calculateLeftSum1(int A[], int L) {
		int i;
		int leftSum = 0;
		int left[] = new int[A.length];
		for (i = 0; i < L; i++) {
			leftSum += A[i];
			left[i] = 0;
		}	
		if (L >= 1) {
			left[i - 1] = leftSum;
		} else {
			left[0] = A[0];
		}

		for (i = L; i < A.length; i++) {
			left[i] = left[i - 1] + A[i] - A[i - L];
		}
		for (i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i], left[i - 1]);
		}
		return left;
	}

	public static int[] calculateRightSum(int A[], int M) {
		int i;
		int rightSum = 0;
		int right[] = new int[A.length + 1 - M];
		// int right[] = new int[A.length];
		for (i = 0; i < M; i++) {
			rightSum += A[A.length - 1 - i];
		}
		right[right.length - 1] = rightSum;
		for (i = right.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] + A[i] - A[i + M];
		}

		for (i = right.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i], right[i + 1]);
		}
		return right;
	}

	public static int[] calculateLeftSum(int A[], int L) {
		int i;
		int leftSum = 0;
		int left[] = new int[A.length + 1 - L];
		// int left[] = new int[A.length];
		for (i = 0; i < L; i++) {
			leftSum += A[i];
		}
		left[0] = leftSum;
		for (i = L; i < A.length; i++) {
			left[i + 1 - L] = left[i - L] + A[i] - A[i - L];
		}
		for (i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i], left[i - 1]);
		}
		return left;
	}

	public static void printArray(int A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + "  ");
		}
		System.out.println();
	}

}
