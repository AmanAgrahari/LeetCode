package Media;

public class GameOfBottlesAlternate {

	public static void main(String[] args) {
		int A[] = { 1, 1, 1, 1, 2, 3, 3, 3 };
		System.out.println(solve(A));
	}

	public static int solve(int A[]) {

		int j = 0;
		int i;
		for (i = 0; i < A.length;) {
			while (A[i] == A[j] && j < A.length - 1)
				j++;
			if (A[i] != A[j] && j < A.length - 1) {
				i++;
				j++;
			}
			if (j == A.length - 1)
				break;
		}
		return (j - i);
	}
}
