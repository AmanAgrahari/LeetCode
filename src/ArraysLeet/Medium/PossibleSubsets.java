package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class PossibleSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> al = subsets(new int [] {1,2,2});
		for(List<Integer> bl:al) {
			System.out.println(bl.toString());
		}
		
	}

	public static List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> al = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < (1 << n); ++i) {
            List<Integer> bl = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (i << j)) >= 1) {
                   bl.add(a[j]);
                }
            }
            al.add(bl);
        }
        return al;
    }
	 
}
