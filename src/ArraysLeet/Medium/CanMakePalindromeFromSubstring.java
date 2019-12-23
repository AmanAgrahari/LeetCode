package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeFromSubstring {
    public static void main(String[] args) {
        int [][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        List<Boolean> al = canMakePaliQueries("abcda",queries);
        System.out.println(al.toString());
    }

    public static  List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        int i,j;
        int preComp[][] = new int[26][s.length()];
        int k = 97;
        for(i = 0; i < 26; i++){
            int c = 0;
            for(j = 0; j < s.length(); j++){
                if(s.charAt(j) == k){
                    c++;
                    preComp[i][j] = c;
                } else {
                    preComp[i][j] = c;
                }
            }
            k++;
        }
       /* for(i = 0; i < 26; i++){
            for(j = 0; j < s.length(); j++){
                System.out.print(preComp[i][j] + " ");
            }
            System.out.println();
        }*/
        List<Boolean> res = new ArrayList<>();
        for(int q[] :queries){
            int left = q[0];
            int right  = q[1];
            k = q[2];
            int sum = 0;
            for(i = 0; i < 26; i++){
                if(left-1 >= 0){
                    sum += (preComp[i][right] - preComp[i][left-1])%2;
                } else {
                    sum += (preComp[i][right])%2;
                }
            }
            res.add(sum/2<=k);
        }
        return res;
    }
}
