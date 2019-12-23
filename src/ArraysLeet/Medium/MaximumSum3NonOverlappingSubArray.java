package ArraysLeet.Medium;

import java.util.Arrays;

public class MaximumSum3NonOverlappingSubArray {

	public static void main(String[] args) {

		int arr[] = {4,3,2,1};
		int k = 1;
		int brr[] = maxSumOfThreeSubarrays(arr, k);
		for (int i : brr) {
			System.out.println(i);
		}
	}

	public static int[] maxSumOfThreeSubarrays(int[] A, int k) {

		int i;
		int middle[] = new int[A.length];
		int leftIndex[] = new int[A.length];
		int rightIndex[] = new int[A.length];
		int left[] = calculateLeftSum1(A, k, leftIndex);
		int right[] = calculateRightSum1(A, k, rightIndex, middle);
		int B[] = new int[3];
		int max = 0;

		if(k ==1 ) {
			for (i = k; i < A.length-2; i++) {
				if (middle[i] + left[i - 1] + right[i + k] > max) {
					max = middle[i] + left[i - 1] + right[i + k];
					B[0] = leftIndex[i - 1];
					B[1] = i;
					B[2] = rightIndex[i + k];
				}
			}
			return B;
		}
		for (i = k; i < A.length - k - 2; i++) {
			if (middle[i] + left[i - 1] + right[i + k] > max) {
				max = middle[i] + left[i - 1] + right[i + k];
				B[0] = leftIndex[i - 1];
				B[1] = i;
				B[2] = rightIndex[i + k];
			}
	//		System.out.println(B[0] + " " + B[1] + " " + B[2]);
		//	System.out.println(middle[i] + left[i - 1] + right[i + k]);
		}
		//System.out.println(max);
		return B;
	}

	public static int[] calculateRightSum1(int A[], int M, int rightIndex[], int[] middle) {
		int i;
		int rightSum = 0;
		int right[] = new int[A.length];
		for(i = A.length - 1; i >= 0; --i) {
			rightIndex[i] = i;
		}
		for (i = A.length - 1; i >= A.length - M; i--) {;
			rightSum += A[i];
		}
		right[A.length - 1] = A[A.length - 1];
		right[A.length - M] = rightSum;

		for (i = right.length - M - 1; i >= 0; i--) {
			right[i] = right[i + 1] + A[i] - A[i + M];
		}
		for(i = M; i < middle.length ;i ++) {
			middle[i] = right[i];
		}
		for (i = right.length  - M-1; i >= 0; i--) {
			if(right[i + 1] > right[i]) {
				right[i] = right[i + 1];
				rightIndex[i] = rightIndex[i + 1];
			} else {
				rightIndex[i] = i;
			}
	//		System.out.println(i + " " + right[i] + " " + rightIndex[i]);
		}
		return right;
	}

	public static int[] calculateLeftSum1(int A[], int L, int leftIndex[]) {
		int i;
		int leftSum = 0;
		int left[] = new int[A.length];
		for (i = 0; i < L; i++) {
			leftSum += A[i];
			left[i] = 0;
		}
		if(i-1>=0)
		left[i-1] = leftSum;
		for (i = L; i < A.length; i++) {
			left[i] = left[i - 1] + A[i] - A[i - L];
		}
		for (i = L - 1; i < left.length; i++) {
			if (i-1 >=0 && left[i - 1] >= left[i]) {
				left[i] = left[i - 1];
				leftIndex[i] = leftIndex[i - 1];
			} else  {
				leftIndex[i] = i - L + 1;
			}
			//System.out.println(i + " " + left[i] + " " + leftIndex[i]);
		}
		return left;
	}
}
