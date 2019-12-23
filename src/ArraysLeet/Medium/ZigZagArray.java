package ArraysLeet.Medium;

public class ZigZagArray {

	public static void main(String[] args) {
		int arr[] = {1,2,2,1,2,1,1,1,1,2,2,2 };
		wiggleSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void wiggleSort(int[] nums) {
		int i;
		boolean flag = true;
		int j = 0;
		for (i = 0; i + 1 < nums.length; i++) {
			if (flag) {
				while(nums[j] == nums[i]) {
					i++;
				}
				if (nums[j] > nums[i]) {
					swap(j, i, nums);
					j++;
				}
				flag = !flag;
			} else {
				while(nums[j] == nums[i]) {
					i++;
				}
				if (nums[j] > nums[i]) {
					swap(j, i, nums);
					j++;
				}
				flag = !flag;
			}
		}
	}

	public static void swap(int i, int j, int nums[]) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
