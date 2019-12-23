package ArraysLeet.Medium;

public class UncrossedLines {
    int dp[][];
    public static void main(String[] args) {
        UncrossedLines uncrossedLines = new UncrossedLines();
        int A[] = {1, 4, 2};
        int B[] = {1, 2, 4};
        System.out.println(uncrossedLines.maxUncrossedLines(A, B));
    }
    public int maxUncrossedLines(int[] A, int[] B) {
        dp = new int[A.length + 1][B.length + 1];
        for(int i = 0; i <= A.length; ++i) {
            for(int j = 0; j <= B.length; ++j) {
                dp[i][j] = -1;
            }
        }
        return lcs(A, B, A.length - 1, B.length - 1);
    }
    public int lcs(int A[], int B[], int i, int j) {
        if(i == -1 || j == -1) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(A[i] == B[j]){
            return dp[i][j] = 1 + lcs(A,B,i-1,j-1);
        }
        return dp[i][j] =  Math.max(lcs(A,B,i-1,j),lcs(A,B,i,j-1));
    }
}
