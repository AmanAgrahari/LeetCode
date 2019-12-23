package ArraysLeet.Medium;

public class SegregateZreoOneAndTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {2,0,1};
		sortColors(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void sortColors(int[] nums) {

		int low = 0;
		int high = nums.length -1;
		int mid = 0;
		while(mid <= high ) {
			switch(nums[mid]) {
			case 0: 
				int temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			case 1: 
				mid++;
				break;
				
			case 2:
				int temp1 = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp1;
				high--;
				break;
			}
		}
	}

}
