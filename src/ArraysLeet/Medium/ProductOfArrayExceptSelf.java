package ArraysLeet.Medium;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5 };
		// op====> 60 40 30 24
		for(int i : productExceptSelf(arr)) {
			System.out.println(i);
		}
	}

	public static int[] productExceptSelf(int[] nums) {

		int leftProd[] = new int[nums.length];
		int rightProd[] = new int[nums.length];
		int i;
		int p = 1;
		for (i = 0; i < nums.length; i++) {
			p *= nums[i];
			leftProd[i] = p;
		}
		// 2 6 24 120
		p = 1;
		for (i = nums.length - 1; i >= 0; i--) {
			p *= nums[i];
			rightProd[i] = p;
		}
		// 120 60 20 5
		int resProd[] = new int[nums.length];
		for (i = 0; i < nums.length; i++) {
			if (i == 0) {
				resProd[i] = rightProd[i + 1];
			} else if (i == nums.length - 1) {
				resProd[i] = leftProd[i - 1];
			} else if (i > 0 && i + 1 < nums.length) {
				resProd[i] = leftProd[i - 1] * rightProd[i + 1];
			}

		}
		return resProd;
	}
}
