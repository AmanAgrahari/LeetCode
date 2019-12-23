package ArraysLeet.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK {

	public static void main(String[] args) {
		/*
		 * int arr[] = {1,1,1};
		 * 
		 * int k = 2; System.out.println(subarraySum(arr, k));
		 */

		String pp = "[{\"companyName\":\"NEW MIRAGE MANAGEMENT CONSULTANTS PTE. LTD.\"}]";
		System.err.println(pp);
	}

	   public int subarraySum(int[] nums, int k) {
	        int s = 0, ans = 0;
	        int i;
	        Map<Integer, Integer> ha = new HashMap<>();
	        ha.put(0,1);
	        for(i = 0; i < nums.length; ++i) {
	            s += nums[i];
	            ans += ha.getOrDefault(s-k,0);
	            ha.put(s,ha.getOrDefault(s,0)+1);
	        }
	        return ans;
	    }

}
