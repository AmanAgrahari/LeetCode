package ArraysLeet.Medium;

public class BestSightSeeingPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,2};
		maxScoreSightseeingPair(arr);
	}

	public static int maxScoreSightseeingPair(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		int i;
		int B[] = new int[A.length];
		int m = A[0];
		m = m -1;
		for(i = 1; i < A.length; i++) {
			B[i] = m + A[i];
			//System.out.println(B[i]);
			if(m-A[i] < 0) {
				m = A[i];
			}
			m = m -1;
		}
		int max = Integer.MIN_VALUE;
		for(i = 1; i< B.length; i++) {
			max = Math.max(max, B[i]);
		}
		//System.out.println("max" + max);
		return max;
	}
}
