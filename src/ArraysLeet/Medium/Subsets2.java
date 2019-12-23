package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> al = subsetsWithDup(new int[] { 1, 2, 2 });
		for (List<Integer> bl : al) {
			System.out.println(bl.toString());
		}
	}

	static void printPowerSet(int [] set, int set_size) {

		/*
		 * set_size of power set of a set with set_size n is (2**n -1)
		 */
		long pow_set_size = (long) Math.pow(2, set_size);
		int counter, j;

		/*
		 * Run from counter 000..0 to 111..1
		 */
		for (counter = 0; counter < pow_set_size; counter++) {
			for (j = 0; j < set_size; j++) {
				/*
				 * Check if jth bit in the counter is set If set then print jth element from set
				 */
				if ((counter & (1 << j)) > 0)
					System.out.print(set[j]);
			}

			System.out.println();
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		findCombination(list, temp, nums, 0);
		return list;
	}

	public static void findCombination(List<List<Integer>> list, List<Integer> temp, int[] A, int i) {
		if (i == A.length) {
			list.add(new ArrayList<Integer>(temp));
			return;
		}
		List<Integer> temp1 = new ArrayList<>(temp);
		temp1.add(A[i]);
		findCombination(list, temp, A, i + 1);
		findCombination(list, temp1, A, i);
	}
}
