package lenskart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mishra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> mat= new ArrayList<>(28);
        int i, j;
        String s;
        for(i = 1; i <= 27; ++i) {
           s = br.readLine();
            s = '$' + s;
            mat.add(s);
        }
        int k = solve(mat,N);
        System.out.println(k);
    }


    public static int solve( List<String> mat, int N) {
        // no of strings of length i and ending with character j
        int dp[][] = new int[N + 1][27];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],0);
        }
        int i, j, k;
        for(i = 1; i <= 26; ++i) {
            dp[1][i] = 1;
        }

        for(i = 2; i <= N; ++i) {
            for(j = 1; j <= 26; ++j) {
                for(k = 1; k <= 26; ++k) {
                    if(mat.get(k).charAt(j) == '1') { // j can be placed after k
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        int ans = 0;
        for(i = 1; i <= 26; ++i) {
            ans += dp[N][i];
            ans %= 1000000007;
        }
        return ans;

    }
}
