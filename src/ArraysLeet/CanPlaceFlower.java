package ArraysLeet;

public class CanPlaceFlower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,0,0};
		System.out.println(canPlaceFlowers(arr,1));
	}
	 public static boolean canPlaceFlowers(int[] arr, int n) {
		 if(arr.length == 1) {
	            if(arr[0] == 0 && n <= 1) {
	                return true;
	            }
	            if(arr[0] == 1 && n == 0) {
	                return true;
	            }
	            return false;
	        }
		 //{1,0,0,0,1,0,0};
		 boolean first = false;
		 boolean second = false;
	        int i, c = 0;
	        for(i = 1; i + 1 < arr.length; ++i) {
             if(arr[i-1] == 0 && arr[i] == 0 && arr[i + 1] == 1) {
            	 first = true;
                  if(i-2 >= 0 && arr[i-2]!=1){
                       arr[i-1] = 1;
		                c++;
                  }
		               	
	            } 
             else if(arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 0) {
		                arr[i] = 1;
		                c++;	
	            } else  if(arr[i-1] == 1 && arr[i] == 0 && arr[i + 1] == 0) {
	            	second = true;
                     if(i+2 <= arr.length-1 && arr[i+2]!=1){
                         arr[i+1] = 1;
		                c++;
                     }
		                	
	            } 
	        }
	        if(first && arr[0] == 0) {
	        	c++;
	        }
	        if(second && arr[arr.length-1] == 0) {
	        	c++;
	        }
     System.out.println(c);
		/*
		 * if(arr[0] == 0 && arr[1] != 1) { c++; } if(arr[arr.length - 1] == 0 &&
		 * arr[arr.length - 2] != 1) { c++; }
		 */
	        return c >= n;
	    }
}
