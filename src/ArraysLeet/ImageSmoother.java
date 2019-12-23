package ArraysLeet;

import java.util.ArrayList;

public class ImageSmoother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = {{1,1,1},
			 {1,0,1},
			 {1,1,1}};
		imageSmoother(arr);
	}
 	public static int[][] imageSmoother(final int [][] matrix) {
		
		int resMat [][] = new int[matrix.length][matrix[0].length];
	        final int r = matrix.length;
	        final int c = matrix[0].length;
	        int i, j;
	        for (i = 0; i < r; i++) {
	            for (j = 0; j < c; j++) {
	            	int ans = 0;
		        	int count = 1;
                    ans+=matrix[i][j];
	                if (valid(i-1, j - 1, r, c)) {
	                    ans+=matrix[i-1][j-1];
	                    count++;
	                }
	                if (valid(i -1, j, r, c) ) {
	                	 ans+=matrix[i-1][j];
	                	 count++;
	                }
                    
	                if (valid(i - 1, j + 1, r, c)) {
	                	ans+=matrix[i-1][j+1];
	                	count++;
	                }
                    
	                if (valid(i , j -1, r, c)) {
	                	ans+=matrix[i][j-1];
	                	count++;
	                }
                     if (valid(i , j + 1, r, c)) {
	                	ans+=matrix[i][j+1];
	                	count++;
	                }             
	                if (valid(i + 1, j - 1, r, c)) {
	                	ans+=matrix[i+1][j-1];
	                	count++;
	                }
	                if (valid(i + 1, j, r, c)) {
	                	ans+=matrix[i+1][j];
	                	count++;
	                }
	               
	                if (valid(i + 1, j + 1, r, c)) {
	                	ans+=matrix[i+1][j+1];
	                	count++;
	                }
	 	           resMat[i][j] = ans/count; 
		        
	            }
	        
	        }
	        return resMat;
	    }

	static boolean valid(final int i, final int j, final int r, final int c) {
		if (i < 0 || i >= r) {
			return false;
		}
		if (j < 0 || j >= c) {
			return false;
		}
		return true;
	}

}
