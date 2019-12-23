package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class AllDuplicates {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(arr).toString());
	}

	public static List<Integer> findDuplicates(int[] nums) {
		int i;
		List<Integer> al = new ArrayList<Integer>();
		for(i = 0; i < nums.length; i++)
			if (nums[Math.abs(nums[i])-1] >= 0) 
				nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
			else {
				al.add(Math.abs(nums[i]));
			}
		return al;
	}
}
