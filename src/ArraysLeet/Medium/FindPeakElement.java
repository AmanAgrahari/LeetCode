package ArraysLeet.Medium;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,2,3,1};
		System.out.println(findPeakElement(arr));
	}

	public static int findPeakElement(int[] nums) {

		int low = 0;
		int high = nums.length - 1;
		if(high == 0) {
			return 0;
		}
		if(nums.length == 2) {
			if(nums[0] > nums[1]) {
				return 0;
			} else {
				return 1;
			}
		}

		while (low <= high) {
			int mid = (low + high) / 2;
		//	System.out.println(mid);
			if(mid == 0) {
				if(nums[mid] < nums[mid + 1]) {
					low = mid + 1;
					continue;
				} else {
					return mid;
				}
			}
			if(mid == nums.length - 1) {
				if(nums[mid] < nums[mid - 1]) {
					high = mid - 1;
					continue;
				} else {
					return mid;
				}
			}
			if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			}
			if((mid + 1 < nums.length && nums[mid + 1] > nums[mid])) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}

		}
		return 0;
	}
}