package ArraysLeet.Medium;

public class MinimumSizeSubArraySum {

	public static void main(String[] args) {
		int arr[] = {2,3,1,2,4,3};

		int s = 7;
		System.out.println(minSubArrayLen(s, arr));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int i = 0; 
		int j = 0;
		int min = 999999;
		int maxSumSoFar = 0;
		for(i = 0; i < nums.length ;i ++) {
			maxSumSoFar += nums[i];
			while(maxSumSoFar >= s) {
				min = Math.min(min, i -j +1);
				maxSumSoFar-=nums[j++];
			}
		}
        return min==999999 ? 0: min;
    }
}

