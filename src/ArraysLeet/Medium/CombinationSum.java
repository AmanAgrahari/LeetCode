package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {

		int arr[] = { 2, 3, 6, 7 };
		int target = 7;
		combinationSum(arr, target);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		findCombination(list, temp, candidates, target, 0);
		System.out.println(list.toString());
		return list;
	}

	public static void findCombination(List<List<Integer>> list, List<Integer> temp, int[] A, int target, int i) {
		if (i == A.length && target == 0) {
			list.add(new ArrayList<Integer>(temp));
			return;
		}
		if (i == A.length && target != 0) {
			return;
		}
		if (target == 0) {
			list.add(new ArrayList<Integer>(temp));
			return;
		}
		if (target < 0) {
			return;
		}
		List<Integer> temp1 = new ArrayList<>(temp);
		temp1.add(A[i]);
		findCombination(list, temp, A, target, i + 1);
		findCombination(list, temp1, A, target - A[i], i);
	}

}
