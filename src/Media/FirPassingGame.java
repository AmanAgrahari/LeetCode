package Media;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class FirPassingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = 10;
		int B = 23;
		int C[] = {86,63,69,0,47,0,99,9,0,0};
	//	int C[] = {86,63,69,0,0,0};
		System.out.println(solve(A, B, C));
	}

	
	public static int solve(int A, int B, int C[]) {
	    A = C.length;
		Stack<Integer> ss = new Stack<>();
		ss.add(B);
		for(int i = 0; i < A; ++i) {
			if(C[i] != 0) {
				ss.add(C[i]);
			} else {
				int j = i;
				int cnt = 0;
				while(j < A && C[j] == 0) {
					j++;
					cnt++;
				}
				i = j - 1;
				if(cnt % 2 != 0) {
					ss.pop();
				}
			}
		}
		
		return ss.peek();
	}

}
