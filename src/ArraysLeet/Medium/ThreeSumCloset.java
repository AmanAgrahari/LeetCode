package ArraysLeet.Medium;

import java.util.Arrays;

public class ThreeSumCloset {

	public static void main(String[] args) {

		int arr[] = { 1, 1, 1, 1 };
		System.out.println(threeSumClosest(arr, -100));
	}

	public static int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length < 3)
			return -1;
		Arrays.sort(nums);
		// -4 -1 1 2
		int closetSum = nums[0] + nums[1] + nums[2];
		int i;
		for (i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(closetSum - target))
					closetSum = sum;
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return closetSum;
	}

}
