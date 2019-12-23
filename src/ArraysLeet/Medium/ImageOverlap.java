package ArraysLeet.Medium;

public class ImageOverlap {
    public static void main(String[] args) {
        int A[][] = {{1,1,0},
                {0,1,0},
                {0,1,0}};
        int B[][] = {{0,0,0},
                {0,1,1},
                {0,0,1}};
        System.out.println(largestOverlap(A,B));
    }

    public static int largestOverlap(int[][] A, int[][] B) {

        int n = A.length;
        int i,j;
        int max = 0;
        for(i = 0; i < n; i++){
            for (j = 0; j < n ; j++){
                max = Math.max(max, Math.max(getOverlap(A,B,i,j),getOverlap(B,A,i,j)));
            }
        }
        return max;
    }
    private static int getOverlap(int[][] A, int[][] B,int row ,int col){

        int sum = 0;
        int n = A.length;
        for(int i = row; i < n; i ++){
            for(int j = col; j < n ; j++){
                sum += A[i][j]* B[i-row][j-col];
            }
        }
        return sum;
    }

}
