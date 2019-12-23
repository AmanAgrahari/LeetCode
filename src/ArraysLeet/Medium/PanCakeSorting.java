package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class PanCakeSorting {

	public static void main(String[] args) {
		int arr[] = {3,2,4,1};
		System.out.println(pancakeSort(arr));
	}
	// 3  2  4  1
	public static List<Integer> pancakeSort(int[] A) {
		int n = A.length - 1;
		int index = A.length;
		List<Integer> al = new ArrayList<Integer>();
		while (n >= 0) {
			index = findMaxTillIndex(A, n);
			al.add(index+1);
			reverseArray(A, 0, index);
			al.add(n+1);
			reverseArray(A, 0, n);
			n--;
		}
		return al;
	}

	public static int findMaxTillIndex(int[] nums, int j) {
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i <= j; i++) {
			if (nums[i] >= max) {
				max = nums[i];
				index = i;
			}
		}
		System.out.println("max : "+ max +"  "+  index);
		return index;
	}

	public static boolean checkArraySorted(int[] nums) {
		for (int i = 0; i + 1 < nums.length; i++) {
			if (nums[i] > nums[i + 1])
				return false;
		}
		return true;
	}

	public static void reverseArray(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void printArray(int nums[]) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
