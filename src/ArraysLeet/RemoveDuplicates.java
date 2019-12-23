package ArraysLeet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int arr1[] = { 1, 12, -5, -6, 50, 3 };
		System.out.println(findMaxAverage(arr1,4));
	}

	public static double findMaxAverage(int[] nums, int k) {
		int i;
		double sum = 0;
		for (i = 0; i < k; i++) {
			sum += nums[i];
		}
		double max = sum;
		for (i = k; i < nums.length; i++) {
			sum = sum - nums[i-k] + nums[i];
			if(sum > max) {
				max = sum;
			}
		}
		return max/k;
	}

	public static int removeDuplicates(int[] nums) {
		int i;
		int c = 1;
		for (i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[c++] = nums[i];
			}
		}
		return nums.length - c;
	}

	public static int dominantIndex(int[] nums) {
		int i;
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] >= max) {
				max = nums[i];
				index = i;
			}
		}
		nums[index] = 0;
		System.out.println(nums[index] + " " + max);
		for (i = 0; i < nums.length; i++) {
			if (nums[i] * 2 > max) {
				return -1;
			}
		}
		return index;
	}

}
