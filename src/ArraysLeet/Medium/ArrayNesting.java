package ArraysLeet.Medium;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 4, 0, 3, 1, 6, 2 };
		System.out.println(arrayNesting(arr));
	}

	public static int arrayNesting(int[] nums) {

		int i = 0;
		if (nums.length == 1) {
			return 1;
		}
		int max = Integer.MIN_VALUE;
		Set<Integer> globalSet = new HashSet<Integer>();
		for (i = 0; i < nums.length; i++) {
			int j = i;
			if(!globalSet.contains(nums[j])) {
				Set<Integer> set = new HashSet<Integer>();
				while (!set.contains(nums[j])) {
					set.add(nums[j]);
					globalSet.add(nums[j]);
					j = nums[j];
				}
				max = Math.max(max, set.size());
			}
		}

		return max;
	}
}
