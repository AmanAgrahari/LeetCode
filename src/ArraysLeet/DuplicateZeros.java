package ArraysLeet;

public class DuplicateZeros {

	public static void main(String[] args) {

		int arr[] = { 1, 0, 2, 3, 0, 4, 5, 0 };
		int brr[] = {0,4,1,0,0,8,0,0,3};
		duplicateZeros(brr);
	}

	public static void duplicateZeros(int[] arr) {
		int i;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				shiftTheZeros(arr, i + 1);
				i=i+1;
			}
		}
	}

	static void shiftTheZeros(int[] arr, int i) {
		System.out.println(i);
		int j;
		for (j = arr.length - 1; j >= i; j--) {
			if (j >= 1)
				arr[j] = arr[j - 1];
		}
		
		for(int l = 0; l <arr.length ;l++) {
			System.out.print(arr[l] + "  ");
		}
		System.out.println();
	}
}
