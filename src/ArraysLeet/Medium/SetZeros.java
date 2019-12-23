package ArraysLeet.Medium;

public class SetZeros {

	public static void main(String[] args) {
		int arr[][] = { {0,1,2,0},{3,4,5,2},{1,3,1,5} };
		
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		printMatrix(arr);
		setZeroes(arr);
		System.out.println("======================");
		printMatrix(arr);
	}

	public static void setZeroes(int[][] matrix) {
		int i, j;
		int k = 0;
		int r = matrix.length;
		int np =-100000;
		int c = matrix[0].length;
		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
					if(matrix[i][j] == 0) {
						updateMatrix(matrix, i, j,np);
				}
			}
		}
		
		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
					if(matrix[i][j] == np) {
						matrix[i][j] = 0;
				}
			}
		}
	}

	private static void updateMatrix(int[][] matrix,int i ,int j,int np) {
		int r = matrix.length;
		int c = matrix[0].length;
		
		for(int p = 0; p < c; p++) {
			if(matrix[i][p]!= 0)
			matrix[i][p] = np;
		}
		
		for(int p = 0; p < r; p++) {
			if(matrix[p][j] != 0)
				matrix[p][j] = np;
		}
	}
	
	
	public static void printMatrix(int matrix[][]) {
		int r = matrix.length;
		int c = matrix[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
