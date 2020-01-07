package ArraysLeet.Medium;

public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {

        int arr[][] = {
        {0,1,1,1},
        {1,1,1,1},
        {0,1,1,1}
    };
        System.out.println(countSquares(arr));
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

    public static int countSquares(int[][] matrix) {
        int i,j;
        int r = matrix.length;
        int c = matrix[0].length;
        int dp[][] = new int[r][c];
        int sum = 0;
        for (i = 0; i < r; i++){
            for(j = 0; j < c;j++){
                if(valid(i-1,j-1,r,c) && valid(i-1,j-1,r,c) && valid(i-1,j-1,r,c) && matrix[i][j]==1){
                    int min = Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i][j-1]);
                    matrix[i][j] = min + 1;
                }
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
