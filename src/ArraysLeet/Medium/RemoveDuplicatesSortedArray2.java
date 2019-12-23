package ArraysLeet.Medium;

public class RemoveDuplicatesSortedArray2 {

	public static void main(String[] args) {
		int arr[] = {0,0,1,1,1,1,2,3,3};
		System.out.println(removeDuplicates(arr));
	}

	public static int removeDuplicates(int[] nums) {

		int i;
		if(nums.length < 3) {
			return nums.length;
		}
		int last = 2;
		for(i = 2; i < nums.length; i++) {
			if(nums[last-2]!= nums[i]) {
				nums[last] = nums[i];
				last++;
			}
		}
		return last;
	}
}
