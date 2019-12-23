package ArraysLeet.Medium;

public class TrappingRainWater {

	public static void main(String[] args) {
	
		int arr[] = {2,0,2};
		System.out.println(trap(arr));
	}

	 public static int trap(int[] height) {
         
         int i,j;
         int n = height.length;
         int leftMax[] = new int[n];
         leftMax[0] = height[0];
         for(i = 1; i < n; i++) {
        	 leftMax[i] = Math.max(leftMax[i-1], height[i]);
         }
         int rightMax[] = new int[n];
         rightMax[n-1] = height[n-1];
         
         for(i = n-2; i>= 0; i-- ) {
        	 rightMax[i] = Math.max(rightMax[i+1], height[i]);
         }
         
         int water = 0;
         for(i = 0; i < n; i++) {
        	 water+= Math.min(leftMax[i], rightMax[i])-height[i];
         }
         return water;
    }
}
