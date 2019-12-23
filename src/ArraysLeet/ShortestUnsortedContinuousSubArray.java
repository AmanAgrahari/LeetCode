package ArraysLeet;

public class ShortestUnsortedContinuousSubArray {

	public static void main(String[] args) {
		int arr[] = { 2, 6, 4, 8, 10, 9, 15 };
		int brr[] = {2,3,3,2,4};

		System.out.println(shortestUnsortedContinuousSubArray(brr));

	}

	static int shortestUnsortedContinuousSubArray(int arr[]) {
		int i, j;
		for (i = 0; i + 1 < arr.length; i++) {
			if (arr[i] <= arr[i + 1]) {
			} else {
				break;
			}
		}
		if (i == arr.length - 1) {
			return 0;
		} 

		for (j = arr.length - 1; j - 1 >= 0; j--) {
			if (arr[j] >= arr[j - 1]) {
			} else {
				break;
			}
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int diff = (j-i);
		int ii = i;
		int jj = j;
		System.out.println(i + " " + j);
		for (; ii <= jj; ii++) {
			max = Math.max(max, arr[ii]);
			min = Math.min(min, arr[ii]);
		}
		int k;
		for (k = i - 1; k >= 0; k--) {
			if (arr[k] <= min) {
				break;
			}
		}
		diff = diff + k;
		for (k = j; k < arr.length; k++) {
			if (arr[k] >= max) {
				break;
			}
		}
		diff = diff + k - (j);
		return diff;
	}
}
