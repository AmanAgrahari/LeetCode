package ArraysLeet.Medium;

import javax.swing.*;

public class FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {

        minFlipsMonoIncr("11");
    }

    public static int minFlipsMonoIncr(String S) {
        int prefixSum [] = new int [S.length()];
        int i;
        prefixSum[0] = S.charAt(0) == '1' ? 1:0;
        for(i = 1; i < S.length(); i++){
            prefixSum[i] = prefixSum[i-1] + ( (S.charAt(i) == '1') ? 1 : 0);
        }
        int min = S.length() - prefixSum[prefixSum.length-1] ;
        for (i = 0; i < S.length(); i++){
            min = Math.min(min, (prefixSum[i] + (S.length()-1- i) - (prefixSum[S.length()-1] - prefixSum[i])));
        }
        return min;
    }
}
