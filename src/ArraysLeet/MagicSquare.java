package ArraysLeet;

public class MagicSquare {
	public static void main(String[] args) {
		int grid[][] = {{4,3,8,4},
		        		{9,5,1,9},
		        		{2,7,6,2}};
		
		int gr[][] = {{5,5,5},
				{5,5,5},
				{5,5,5}};
		int i, j, ans = 0;
        int row = gr.length;
        int col = gr[0].length;
        for(i = 0; i < row -2; ++i) {
            for(j = 0; j < col-2; ++j) {
                if (magicSquare(gr, i, j)) {
                	ans = ans +1;
                } 
            }
        }
        System.out.println(ans);
		
	}
	
	
	public static  boolean magicSquare(int arr[][], int i, int j) {
		int r1 = arr[i][j]+ arr[i][j+1]+arr[i][j+2];
		int r2 = arr[i+1][j]+ arr[i+1][j+1]+arr[i+1][j+2];
		int r3 = arr[i+2][j]+ arr[i+2][j+1]+arr[i+2][j+2];

		int c1 = arr[i][j]+ arr[i+1][j]+arr[i+2][j];
		int c2 = arr[i][j+1]+ arr[i+1][j+1]+arr[i+2][j+1];
		int c3 = arr[i][j+2]+ arr[i+1][j+2]+arr[i+2][j+2];
		
		int left = arr[i][j] + arr[i+1][j+1] + arr[i+2][j+2];
		int right = arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j];
		
		if((r1 == r2) && (r2== r3) && (r3 == c1)
				&& (c1 == c2) &&(c2 == c3) &&
				(c3 == left) && (left == right) && (right==r1))
		return true;
		return false;
	}
}
