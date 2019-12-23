package ArraysLeet.Medium;

public class SearchIn2DMatrix {

	public static void main(String[] args) {
		int arr[][] = {
		               {1,   3,  5,  7},
		               {10, 11, 16, 20},
		               {23, 30, 34, 50}};
		System.out.println(searchMatrix(arr, 13));
	}
	
	 public static boolean searchMatrix(int[][] matrix, int target) {
	        int i = matrix.length-1;
	        int j = matrix[0].length-1;
	     
	        System.out.println(i+ "  " + j);
	        int k = 0;
	        while(j >= 0 && k<=i) {
	        	if(matrix[k][j] == target)
	        		return true;
	        	else if(matrix[k][j] > target) {
	        			j--;
	        	} else if(matrix[k][j] < target) {
	        		k++;
	        	}
	        }
	        return false;
	    }
}
