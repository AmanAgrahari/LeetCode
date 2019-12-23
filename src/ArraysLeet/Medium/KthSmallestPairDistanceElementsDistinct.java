package ArraysLeet.Medium;

public class KthSmallestPairDistanceElementsDistinct {

	public static void main(String[] args) {

		int arr[] = { 1,3,8,10,15 };
		int k = 5;
		String INDUSTRY_SSIC_1 ="47311";
		String INDUSTRY_SSIC_2 ="46561";
		if(INDUSTRY_SSIC_1.equals("47311")) {
			System.out.println(10);
		}
		System.out.println(smallestDistancePair(arr, k));
	}

	public static int smallestDistancePair(int[] nums, int k) {
		int alpha = 1;
		int n = nums.length;
		while (k > (n - alpha)) {
			k = k - (n - alpha);
			alpha++;
			System.out.println(k);
		}
		// kth (2) pair batana hai alpha ki value par (3)
		System.out.println(alpha + " "+ k);
		int i = 0 ,j = alpha;
		int c = 0;
		int pair []  = new int[n-alpha];
		while(i < n - 3) {
			while(j < n) {
				pair[c] = nums[j] - nums[i];
				j = j+k;
			}
			i++;
		}
		for(int l:  pair) {
			System.out.print(l + " ");
		}
		return 0;
	}
}
