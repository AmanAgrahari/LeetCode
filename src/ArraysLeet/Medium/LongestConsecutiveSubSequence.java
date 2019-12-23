package ArraysLeet.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubSequence {

	public static void main(String[] args) {
		
		int arr[] = {100, 4, 200, 1, 3, 2};

		System.out.println(longestConsecutive(arr));
	}

	public static int longestConsecutive(int[] nums) {
    
		int i;
		Set<Integer> set = new HashSet<Integer>();
		for(i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		
		int ans = 0;
		for( i = 0; i < nums.length; i++) {
			ans = Math.max(ans,find(set, nums[i]));
		}
		return ans;
    }
	private static int find(Set<Integer> set, int i) {
		
		int c = 0;
		for (Integer temp : set) {
	        if(set.contains(i)) {
	        	i++;
	        	c++;
	        	continue;
	        }
	        break;
	     }
		return c;
	}

}
