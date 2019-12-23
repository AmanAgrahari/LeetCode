package ArraysLeet.Medium;

public class MaximimProductSubarray {

	public static void main(String[] args) {
		int arr[] = {3,-1,4};
		System.out.println(maxProduct(arr));
	}

	public static int maxProduct(int[] nums) {
		long positiveArray [] = new long[nums.length];
		long negativeArray [] = new long[nums.length];
		int i;
		long currProdleft = 1;
		for(i = 0; i < nums.length; i++) {
			currProdleft *= nums[i];
			if(currProdleft > 0) {
				positiveArray[i] = currProdleft;
			} else {
				negativeArray[i] = currProdleft;
			}
			 if(currProdleft == 0){
				 currProdleft =1;
	            }
		}
		
		long positiveArray1 [] = new long[nums.length];
		long negativeArray1 [] = new long[nums.length];
		
		long currProdRight = 1;
		for(i = nums.length-1; i >=0; i--) {
			currProdRight *= nums[i];
			if(currProdRight > 0) {
				positiveArray1[i] = currProdRight;
			} else {
				negativeArray1[i] = currProdRight;
			}
			 if(currProdRight == 0){
				 currProdRight =1;
	            }
		}
		long max = Integer.MIN_VALUE;
		long max1 = Integer.MIN_VALUE;
		for(i = 0; i < nums.length; i++) {
			max = Math.max(max ,Math.max(positiveArray[i], negativeArray[i]));
			max1 = Math.max(max1 ,Math.max(positiveArray1[i], negativeArray1[i]));
		}
		return (int)Math.max(max, max1);
	}

}
