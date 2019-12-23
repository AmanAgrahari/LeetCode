package ArraysLeet.Medium;

public class FindFirstAndLastPositionArray {

	public static void main(String[] args) {

		int arr[] = {5,7,7,8,8,10};
		searchRange(arr, 6);
		
	}

	public static int[] searchRange(int[] nums, int target) {
		int arr[] = new int[2];
		arr[0] = findFirstIndex(nums, target);
		System.out.println(arr[0]);
		arr[1] = findLastIndex(nums, target);
		System.out.println(arr[1]);
		return arr;
	}
	
	static int findFirstIndex(int arr[], int target) {
		int low = 0;
		int high = arr.length -1;
		int ans = -1;
		while(low <= high) {
			int mid = ((high -low)/2) + low;
			if(arr[mid] == target) {
				ans = mid;
				high = mid -1;
				continue;
			} else if(arr[mid] > target) {
				high = mid -1;
			} else {
				low = mid +1;
			}
		}
		return ans;
	}
	
	
	static int findLastIndex(int arr[], int target) {
		int low = 0;
		int high = arr.length -1;
		int ans = -1;
		while(low <= high) {
			int mid = ((high -low)/2) + low;
			if(arr[mid] == target) {
				ans = mid;
				low = mid +1;
				continue;
				
			} else if(arr[mid] > target) {
				high = mid -1;
			} else {
				low = mid +1;
			}
		}
		return ans;
	}
}
