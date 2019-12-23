package ArraysLeet.Medium;

public class FirstMissingPositive {

	public static void main(String[] args) {

		int arr[] = {7,8,9,11,12};
		System.out.println(firstMissingPositive(arr));
	}

	public static int firstMissingPositive(int[] nums) {
		int i = 0;
		int j = 0;
		while(i <= nums.length -1 && j<= nums.length -1 && i <= j) {
			if(nums[j] > 0) {
				j++;
				continue;
			} else {
				swap(nums, i, j);
				i++;
				j++;
			}
		}
		printArray(nums);
		int start = i;
		for(; i < nums.length; i++) {
			int n = Math.abs(nums[i]);
			if(n > (nums.length - start)) {
				continue;
			} else if(nums[n + start - 1] > 0) {
				nums[n - 1 + start] = - nums[n - 1 + start];
			}
		}
		printArray(nums);
		
		return firstPositive(nums, start)+1;
	}
	
	private static int firstPositive(int [] nums,int start) {
		int i;
		for(i = start; i < nums.length; i++) {
			if(nums[i] > 0) {
				return i - start;
			}
		}
		return i - start;
	}
	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	private static void printArray(int [] nums) {
		System.out.println();
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "  ");
		}
		System.out.println();
	}
}
