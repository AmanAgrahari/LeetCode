package Media;

import java.util.Map;
import java.util.TreeMap;

public class GameOfBottles {

	public static void main(String[] args) {

		int A[] = { 1, 1, 1, 2, 2, 3, 3, 4, 4 };
		System.out.println(solve(A));
	}

	public static int solve(int A[]) {

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			map.putIfAbsent(A[i], 0);
			map.put(A[i], map.get(A[i]) + 1);
		}
		int B[] = new int[map.size()];
		
		int k = 0;
		for(Integer i: map.keySet()) {
			B[k++] = map.get(i);
		}

		for(int i = 1; i< B.length; i++) {
			if(B[i-1] > B[i]) {
				B[i] = Math.abs(B[i-1] - B[i]);
			} else if(B[i-1] < B[i]){
				
			} else {
				B[i] =0;
			}
		}
		return 0;
	}
}
