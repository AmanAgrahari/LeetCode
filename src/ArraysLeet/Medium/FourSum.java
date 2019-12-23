package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {
		int arr[] = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> list = fourSum(arr, 0);

		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for (List<Integer> al : list) {
			set.add(al);
		}
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		Iterator<List<Integer>> value = set.iterator();
		while (value.hasNext()) {
			list1.add(value.next());
		}

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> al = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4)
			return al;
		Arrays.sort(nums);
		int i, j;
		for (i = 0; i < nums.length; i++) {
			for (j = i + 1; j < nums.length; j++) {
				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						List<Integer> bl = new ArrayList<Integer>();
						bl.add(nums[i]);
						bl.add(nums[j]);
						bl.add(nums[left]);
						bl.add(nums[right]);
						al.add(bl);
					}
					if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}

		return al;
	}

}
