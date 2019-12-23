package ArraysLeet.Medium;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(longestIncreasingSubsequence(arr));
    }

    static int longestIncreasingSubsequence(int arr[]){
        int i,j,max = 0;
        int dp[] = new int[arr.length];
        for(i = 0; i < arr.length; i++){
            dp[i]=1;
        }

        for(i = 1; i < arr.length; i++){
            for(j = 0; j < i; j++){
                if( arr[i] > arr[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            if ( max < dp[i] )
                max = dp[i];
        }
        return max;
    }
}
