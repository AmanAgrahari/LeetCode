package ArraysLeet.Medium;

import java.util.Stack;

public class SumOfSubArrayMinimum {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 2, 4 };
		System.out.println(sumSubarrayMins(arr));
	}

	public static int sumSubarrayMins(int[] A) {
		int i;
		Stack<Integer> left = new Stack<Integer>();
		int L[] = new int[A.length];
		left.push(0);
		L[0] = -1;
		for (i = 1; i < A.length; i++) {
			while (!left.isEmpty() && A[left.peek()] > A[i]) {
				left.pop();
			}
			L[i] = (left.isEmpty()) ? -1 : left.peek();
			left.push(i);
		}

		Stack<Integer> right = new Stack<Integer>();
		int R[] = new int[A.length];
		R[A.length - 1] = A.length;
		right.push(A.length - 1);

		for (i = A.length - 2; i >= 0; i--) {
			while (!right.isEmpty() && A[right.peek()] > A[i]) {
				right.pop();
			}
			R[i] = (right.empty()) ? A.length  : right.peek();
			right.push(i);
		}

		int sum = 0;
		for (i = 0; i < A.length; i++) {
			System.out.println(i + " " + L[i] + " " + R[i]);
			int a = (i - L[i]) % 1000000007;
			int b = (R[i] - i) % 1000000007;
			System.out.println(a + " " + b);
			a = a * b;
			long x = (a * A[i]);
			x %= 1000000007;
			sum += x;
			sum %= 1000000007;
		}
		return sum;
	}

}
