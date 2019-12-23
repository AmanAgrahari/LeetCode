package ArraysLeet;

import java.util.ArrayList;
import java.util.List;

public class CanPlaceFlower1 {

	public static void main(String[] args) {
		int arr[] = { 1, 0, 1, 0, 0, 1, 0, 1 };
		int brr[] = {1,0,0,0,1};
		
		System.out.println(canPlaceFlowers(brr,1));
	}

	public static boolean canPlaceFlowers(int[] arr, int n) {
		int i;
		List<Integer> al = new ArrayList<Integer>();
	     for(i= 0; i< arr.length; i++) {
	    	 if(arr[i] == 1) {
	    		 al.add(i);
	    	 }
	     }
	     
	     int s = 0;
	     for(int j = 0 ; j+1 < al.size(); j++) {
	    	 int c = al.get(j+1) - al.get(j) - 2;
	    	 s += floorCeil(c);
	     }
	     int firstIndexContribution = floorCeil(al.get(0) -1);
	     int lastIndexContribution = floorCeil(arr.length-1- al.get(al.size()-1));
	     System.out.println(firstIndexContribution +lastIndexContribution +s );
		 return ((firstIndexContribution + lastIndexContribution +s) >= n);
	    }
	
	
	static int floorCeil(int c) {
		if(c <= 0) return 0;
		return (c==1)? 1 : (c == 2) ? 1 : (c>2) && (c%2==0) ? c/2: (c+1)/2;
	}
}
