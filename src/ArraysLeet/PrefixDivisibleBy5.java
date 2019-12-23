package ArraysLeet;

import java.util.ArrayList;
import java.util.List;

public class PrefixDivisibleBy5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,1,0,1};
		for(Boolean flag:prefixesDivBy5(arr)) {
			System.out.println(flag);
		}
	}

	public static List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> al = new ArrayList<Boolean>();
		int i;
		long sum = 0;
		for(i = 0; i < A.length; i++) {
			sum += (sum + A[i]* Math.pow(2, A[i]));
			if(sum % 5 == 0) {
				al.add(true);
			} else {
				al.add(false);
			}
			sum = sum % 5;
		}
		return al;
	}
}
