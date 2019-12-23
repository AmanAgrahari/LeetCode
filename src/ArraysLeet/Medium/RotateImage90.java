package ArraysLeet.Medium;

public class RotateImage90 {

	public static void main(String[] args) {
		int arr[][] = { { 1,2 }, { 3,4 } };

		rotate(arr);
	}

	public static void rotate(int[][] matrix) {
		int i, j;
		int r = matrix.length;
		int c = matrix[0].length;
		for (i = 0; i < r; i++) {
			for (j = i; j < c; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (i = 0; i < r / 2; i++) {
			for (j = 0; j < c; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[j][r - 1 - i];
				matrix[j][r - 1 - i] = temp;
			}
		}
		
		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
				System.out.print(matrix[i][j] +"  ");
			}
			System.out.println();
			}

	}
}
