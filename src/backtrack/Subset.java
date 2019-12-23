package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {

        List<Integer> al = Arrays.asList(0,1,2,3);
        List<Integer> bl = new ArrayList<>();
        int n = al.size();
        subsets(al,bl,0);


        int a = 4;
        int b = 6;

        System.out.println(Math.subtractExact(a, b));
    }

    public static void subsets(List<Integer> A, List<Integer> B,int n) {

        if(B.size() == 2){
            System.out.println(B.toString());
        }
        for(int i = n; i < A.size();i++){
            B.add(A.get(i));
            subsets(A,B,i+1);
            B.remove(B.size()-1);
        }
        return;
    }

    public static void uniqueSubsets(List<Integer> S, List<Integer> out,int i) {
        if (i < 0) {
            System.out.println(out);
            return;
        }

        // include current element in the current subset and recur
        out.add(S.get(i));
        uniqueSubsets(S, out, i - 1);

        // exclude current element in the current subset
        out.remove(out.size() - 1); // backtrack

        // remove adjacent duplicate elements
        while (i > 0 && S.get(i) == S.get(i - 1)) {
            i--;
        }

        // exclude current element in the current subset and recur
        uniqueSubsets(S, out, i - 1);
    }

}
