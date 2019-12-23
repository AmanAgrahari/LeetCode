package ArraysLeet.Medium;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int arr[][] = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } 
				};
		
		System.out.println(maxAreaOfIsland(arr));

	}

	public static int maxAreaOfIsland(int[][] grid) {
		int i, j;
		int r = grid.length;
		int c = grid[0].length;
		int vis[][] = new int[r][c];
		int ans = Integer.MIN_VALUE;	
		for (i = 0; i < grid.length; i++) {
			for (j = 0; j < grid[0].length; j++) {
				ans = Math.max(ans, areaBack(i, j, r, c, grid, vis));
			}
		}
        return ans;
	}
	
	static int areaBack(int i,  int j, int r, int c, int [][] grid, int [][] vis) {
		int ans = 0;
		if(isValid(i, j, r, c, grid, vis)) {
			vis[i][j] = ans = 1;
			ans += areaBack(i + 1, j, r, c, grid, vis);
			ans += areaBack(i, j + 1, r, c, grid, vis);
			ans += areaBack(i - 1, j, r, c, grid, vis);
			ans += areaBack(i, j - 1, r, c, grid, vis);
		}
		return ans;
	}
	static boolean isValid(int i, int j, int r, int c, int [][] grid, int [][] vis) {
		return (i >= 0 && j >= 0 && i < r && j < c && grid[i][j] == 1 && vis[i][j] == 0);
	}

}
