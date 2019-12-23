package ArraysLeet;

public class NonDecreasingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 6, 4, 8, 10, 9, 15 };
		int brr[] = {2,3,3,2,4};
		
		System.out.println(checkPossibility(arr));
	}

	public static boolean checkPossibility(int[] nums) {
		int i;
		if(nums.length<=2)
			return true;
		int c = 0;
		for(i = 0; i < nums.length - 1; ++i) {
			if(c > 1) {
				return false;
			}
			if(nums[i] > nums[i + 1]) {
				// try for i
				int tmp = nums[i];
				nums[i] = nums[i + 1];
				if(isValidChani(nums, i)) {
					c++;
					continue;
				}
				nums[i] = tmp;
				// try for i + 1
				tmp = nums[i + 1];
				nums[i + 1] = nums[i];
				if(isValidChanip1(nums, i + 1)) {
					c++;
					continue;
				}
				nums[i + 1] = tmp;
				return false;
			}
		}
		return c <= 1;
	}
	
	public static boolean isValidChani(int[] nums, int i) {
		return (i == 0 || nums[i - 1] <= nums[i]);
	}
	public static boolean isValidChanip1(int[] nums, int i) {
		return(i == nums.length - 1 || nums[i] <= nums[i+1]);
	}

}
