package ArraysLeet;

public class RotateArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7}; 
		int k = 3;
		k = k% arr.length;
			rotate(arr,k);
			printArray(arr);
	}

	
	 public static void rotate(int[] nums, int k) {
	     
		 reverseArray(nums, nums.length-k, nums.length-1);
		 reverseArray(nums, 0, nums.length -k-1);
		 reverseArray(nums, 0, nums.length-1);
	 }
	 
	 public static void reverseArray(int []nums,int i, int j) {
		 while(i < j) {
			 int temp = nums[i];
			 nums[i] = nums[j];
			 nums[j] = temp;
			 i++;
			 j--;
		 }
	 }
	 
	 public static void printArray(int nums[]) {
		 for(int i =0; i< nums.length; i++) {
			 System.out.print(nums[i]);
		 }
	 }
}
