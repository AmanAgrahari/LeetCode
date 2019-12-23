import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {

		List<Integer> al = new ArrayList<Integer>();

		int a[] = {1,3,1,5,4};
		int target = 6;
		/*
		 * String s = String.valueOf(target); System.out.println(s);
		 * System.out.println(searchInsert(a, target));
		 */
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println(findPairs(a, 0));
	}
	  public static int findPairs(int[] nums, int k) {
		    
	        Map<Integer,Integer> map = new ConcurrentHashMap<>();
	        for(int i = 0; i < nums.length; i++){
	            map.putIfAbsent(nums[i], 0);
	            map.put(nums[i],map.get(nums[i])+1);
	        }
	        int res = 0;
	        int pp = 0;
	        for(Integer i:map.keySet()){
	        	int kk = map.get(i);
	            if(kk >= 2) {
	            	pp = kk/2;
	            	if(kk%2==0) {
	            		map.remove(i);
	            	} else {
	            		map.put(i, 1);
	            	}
	            }
	            res+=pp;
	        }
	        int c =0;
	        for(Integer i:map.keySet()){
	           if(map.containsKey(i-k)) {
	        	   c++;
	           }
	        }
	        System.out.println(c);
		        return c+res;
	    }
    public static int searchInsert(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        int ans = 0;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                    ans = mid;
                    start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans+1;
    }

}
