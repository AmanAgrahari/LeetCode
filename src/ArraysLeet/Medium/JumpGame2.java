package ArraysLeet.Medium;

public class JumpGame2 {

	public static void main(String[] args) {

		int nums[] = { 5, 3, 1, 1, 1, 2, 1 };
		int nums1[] = { 4, 3, 7, 1, 2, 6, 7, 6 };
		//int check[] = { 0,2, 3 };
		System.out.println(jumps(nums));
	}

	public static int jumps(int[] nums) {
	 	if (nums.length == 1)
			return 0;

		if (nums[0] >= nums.length - 1)
			return 1;
		
		int jumps[] = new int[nums.length];
		jumps[0] = 0;
		
		int i = 0;
		int j = i+1;
		for( i = 0; i < nums.length; i++) {
			for(j = 1; j <= nums[i] && i+j < nums.length; j++) {
				if(jumps[i+j] == 0 || jumps[i+j] > jumps[i] +1)
				jumps[i+j]= jumps[i]+1;
			}
		}
		return jumps[nums.length -1];  
	}
}
