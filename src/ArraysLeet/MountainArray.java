package ArraysLeet;

public class MountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.println(validMountainArray(arr));
	}

	public static boolean validMountainArray(int[] A) {

		int i;
		int n = A.length;
		if (n <= 2)
			return false;
		for (i = 0; i + 1 < n; i++) {
			if (A[i] < A[i + 1]) {

			} else {
				break;
			}
		}
		if (i == 0) {
			for (i = 0; i + 1 < n; i++) {
				if (A[i] > A[i + 1]) {

				} else {
					break;
				}
			}
		}	
		if (i + 1 == A.length)
			return false;

		for (; i + 1 < n; i++) {
			if (A[i] > A[i + 1]) {

			} else {
				break;
			}
		}
		if (i + 1 == A.length)
			return true;
		return false;
	}

}
