package ArraysLeet.Medium;

import java.util.ArrayList;

public class KthSmallestInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(matrix,8));
	}

	public static int kthSmallest(int[][] arr, int k) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
	      for(int i = 0; i < arr.length; i++) {
	          for(int j = 0; j < arr[0].length; j++) {
	        	  	list.add(arr[i][j]);
	          }
	      }
		return list.get(k-1);
	}
}
