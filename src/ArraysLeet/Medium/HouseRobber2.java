package ArraysLeet.Medium;

public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int D = 5;
		System.out.println(shipWithinDays(arr, D));

	}

	public static boolean isPossible(int[] weights, int D, int w) {
		int i, s = 0, days = 0;
		for (i = 0; i < weights.length; ++i) {
			if(weights[i] > w) {
				return false;
			}
			if (s + weights[i] > w) {
				days++;
				s = 0;
				i--;
			} else {
				s += weights[i];
			}
		}
		days++;
	//	System.out.println(w + " " + (days <= D));
		return days <= D;
	}

	public static int shipWithinDays(int[] weights, int D) {
		int low = 0, ans = 0;
		int high = calculateSumTillIndex(weights, weights.length);
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(weights, D, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static int calculateSumTillIndex(int nums[], int index) {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += nums[i];
		}
		return sum;
	}
}
