package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTriangleNumber {

	public static void main(String[] args) {
		int arr[] = {2,2,3,4};
		System.out.println(threeSum(arr).toString());
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		//-4 -1 -1 0 1 2 
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int i;
		for(i = 0; i+1 < nums.length; i++) {
			int j = i+1;
			int k = nums.length -1;
			while(j < k) {
				int sum = nums[i] + nums[j];
				if(sum > nums[k]) {
					ArrayList<Integer> al = new ArrayList<Integer>();
					al.add(nums[i]);
					al.add(nums[j]);
					al.add(nums[k]);
					list.add(al);
				}
				if(sum > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return list;
	}
}
