
public class SearchInsertPosition {

	public static void main(String[] args) {
	
		int arr[]  = {0,0,1,1,1,2,2,3,3,4};
		int k = 2;
		System.out.println(removeDuplicates(arr));

	}

	public static int searchInsert(int[] nums, int target) {
		
		int start = 0;
		int end = nums.length-1;
		int ans = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			if(nums[mid] == target) {
				return mid;
			} 
			else if(nums[mid]< target) {
				ans = mid+1;
				start = mid+1;
			} else {
				ans = mid+1;
				end = mid-1;
			}
		}
		return ans;
	}
	
	 public static int removeDuplicates(int[] nums) {
	        int i,j;
	        Boolean flag = false;
	        int c =0;
	        for( i = 0; i < nums.length; i++){
	            j = i+1;
	            while(j < nums.length){
	                if(nums[i] == nums[j]){
	                    j=j+1;
	                    if(!flag){
	                        c++;
	                        flag = true;
	                    }
	                    continue;    
	                } else {
	                	break;
	                }
	            }
	            if(!flag){
	                c++;
	            }
	        }
	        return c;
	    }
}
