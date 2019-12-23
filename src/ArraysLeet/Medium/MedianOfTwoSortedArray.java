package ArraysLeet.Medium;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int X[] = { 1, 3 };
		int Y[] = { 2 };

		int X1[] = { 23, 26, 31, 35 };
		int Y1[] = { 3, 5, 7, 9, 11, 16 };
		findMedian(X1, Y1);
	}

	static void findMedian(int X[], int Y[]) {
		int startX = 0;
		int endX = X.length - 1;
		int lengthX = X.length;
		int lengthY = Y.length;
		System.out.println(lengthX + "  " + lengthY);
		int partitionX = 0;
		int partitionY = 0;
		int median = 0;
		while (startX <= endX) {
			partitionX = (startX + endX) / 2;
			partitionY = ((lengthX + lengthY + 1) / 2) - partitionX;
			System.out.println(partitionX + " " + partitionY);

			if (partitionX == 0 && Y[partitionY - 1] <= X[partitionX]) {
				median = ((X.length + Y.length) % 2 != 0) ? Math.max(X[partitionX - 1], Y[partitionY - 1])
						: (Math.max(-999999, Y[partitionY]) + Math.min(X[partitionX], Y[partitionY - 1])) / 2;
				break;
			}
			if (X[partitionX - 1] <= Y[partitionY] && Y[partitionY - 1] <= X[partitionX]) {
				median = ((X.length + Y.length) % 2 != 0) ? Math.max(X[partitionX - 1], Y[partitionY - 1])
						: (Math.max(X[partitionX - 1], Y[partitionY]) + Math.min(X[partitionX], Y[partitionY - 1])) / 2;
				break;
			} else if (X[partitionX - 1] >= Y[partitionY]) {
				endX = partitionX - 1;
			} else {
				startX = partitionX + 1;
			}
		}
		System.out.println(median);
	}

	public double findMedianSortedArrays(int input1[], int input2[]) {
		if (input1.length > input2.length) {
			return findMedianSortedArrays(input2, input1);
		}
		int x = input1.length;
		int y = input2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else { 
				low = partitionX + 1;
			}
		}
		return 0.0;
	}
}
