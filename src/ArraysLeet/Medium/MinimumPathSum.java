package ArraysLeet.Medium;

public class MinimumPathSum {

	public static void main(String[] args) {
		int arr[][] = {
		              {1,3,1},
		              {1,5,1},
		              {4,2,1},
		};
		
		System.out.println(minPathSum(arr));

	}

	public static int minPathSum(int[][] grid) {

		int i,j;
		int m = grid.length;
		int n = grid[0].length;
		for(i = 1; i < m ;i++) {
			grid[0][i]= grid[0][i] +grid[0][i-1] ;
		}
		for(i = 1; i < m ;i++) {
			grid[i][0]= grid[i][0] +grid[i-1][0] ;
		}
		
		for(i = 1; i < m; i++) {
			for( j = 1; j < n ;j++) {
				grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]); 
			}
		}
		
		return grid[m-1][n-1];
	}

}
