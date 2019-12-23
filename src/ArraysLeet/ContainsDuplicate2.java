package ArraysLeet;

import java.util.HashMap;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		int arr[] = { 99,99 };
		int k = 2;
		System.out.println(containsNearbyDuplicate(arr, k));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		int i;
		int l = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				l = map.get(nums[i]);
				if((i-l) <= k)
				return true;
				map.put(nums[i], i);
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

}
