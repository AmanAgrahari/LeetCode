package ArraysLeet.Medium;

public class MinimumDominoRotation {

	public static void main(String[] args) {
		int arr[] = { 3,5,1,2,3 };
		int brr[] = { 3,6,3,3,4 };
		System.out.println(minDominoRotations(arr, brr));
	}

	public static int minDominoRotations(int[] A, int[] B) {
		int C[] = new int[7];
		int D[] = new int[7];
		int i,j;
		int max1 = -1;
		int posOfA = 0;
		int posOfB = 0;
		int max2 = -1;
		for(i = 1; i <= A.length ;i++) {
			C[A[i-1]]++;
			D[B[i-1]]++;
		}
		
		for(i = 1; i < 7; i++) {
			if(C[i] > max1) {
				max1 = C[i];
				posOfA = i;
			}
			if(D[i] > max2) {
				max2 = D[i];
				posOfB = i;
			}
		}
		
		int freqNumA = C[posOfA];
		int freqNumB = D[posOfB];
		System.out.println(freqNumA + "  " + posOfA);
		System.out.println(freqNumB + "  " + posOfB);
		
		if(freqNumA > freqNumB) {
			return swap(A,B,posOfA);
		} else {
			return swap(B,A,posOfB);
		}
	}
	
	public static int swap(int C[], int D[],int num) {
		int i;
		int countSwap = 0;
		for(i = 0; i < C.length; i++) {
			if(C[i]!= num) {
				int temp = C[i];
				C[i] = D[i];
				D[i] = temp;
				countSwap++;
				if(check(C,num)) {
					return countSwap;
				}
			}
		}
		return -1;
	}

	private static boolean check(int[] c,int num) {
		int i;
		for(i = 0; i< c.length; i++)
			if(c[i]!=num)
				return false;
		return true;
	}
}
