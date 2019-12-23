package ArraysLeet;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NumberOfSubArraysWithBoundedMaximum {

	public static void main(String[] args) {

		int arr[] = {4,4,4,1,4 };
		List<List<Integer>>  al = printSubsequences(arr);
		for (List<Integer> cl : al) {
			System.out.println(cl.toString());
		}
	}

	static List<List<Integer>> printSubsequences(int arr[]) {
		int n = arr.length;
		Arrays.sort(arr);
		int opsize = (int) Math.pow(2, n);
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		for (int counter = 1; counter < opsize; counter++) {
			ArrayList<Integer> bl = new ArrayList<Integer>();
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (BigInteger.valueOf(counter).testBit(j))
					bl.add(arr[j]);
			}
			if (bl.size() != 0)
				al.add(bl);
		}
		

		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for (List<Integer> cl : al) {
			set.add(cl);
		}

		Iterator<List<Integer>> value = set.iterator();
		while (value.hasNext()) {
			list1.add(value.next());
		}
		return list1;
	}
}
