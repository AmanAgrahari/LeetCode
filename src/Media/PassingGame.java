package Media;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PassingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = 10;
		int B = 23;
		int C[] = {86,63,69,0,47,0,99,9,0,0};
		System.out.println(solve(A, B, C));
	}

	
	public static int solve(int A, int B, int C[]) {
		
		
		Map<Integer,Integer> map = new LinkedHashMap();
		
		int K = 0;
		for(int i =0; i< C.length; i++) {
			K = B;
			if(C[i] != 0) {
				map.put(B, C[i]);
				B = C[i];
				
			} else {
				map.put(B, K);
				B = K;
			}
		}
		
		return K;
	}
}
