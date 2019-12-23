package ArraysLeet.Medium;

public class NextPermutation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4,3,1,2};
		nextPermutation(arr);
	}

	public static void nextPermutation(int[] nums) {
		if(nums == null || nums.length <=1)
            return;
		int i;
		int mark = -1;
		for (i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i-1]) {
				mark = i - 1;
				break;
			}
		}

		if (mark == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		
		int j = nums.length - 1;
		for (i = nums.length - 1; i >= mark + 1; i--) {
			if (nums[i] > nums[mark]) {
				j = i;
				break;
			}
		}
		swap(nums, mark, j);

		reverse(nums, mark + 1, nums.length - 1);
		print(nums);
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	private static void reverse(int[] nums, int i, int j) {
		    while (i < j) {
		        swap(nums, i, j);
		        i++;
		        j--;
		    }
	}

	private static void print(int[] nums){
		for (int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
