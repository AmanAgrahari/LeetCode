package Samsung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class City {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			long arr[] = new long[n + 1];
			int i;
			for (i = 1; i < n + 1; i++) {
				arr[i] = sc.nextLong();
			}
			Map<Long, List<Long>> map = new HashMap<Long, List<Long>>();
			long dest = 0;
			for (i = 1; i <= n; i++) {
				dest = (i + (i % k) + 1);
				map.putIfAbsent(dest, new ArrayList<Long>());
				map.get(dest).add((long) i);
			}
			long dp[] = new long[n + 1];
			dp[1] = arr[1];
			for (i = 2; i <= n; i++) {
				dp[i] = Math.min(dp[i - 1], findMin(map.get((long)i), dp)) + arr[i];
			}
			System.out.println(dp[n]);
		}

	}

	static long findMin(List<Long> al, long arr[]) {
		if(al == null) {
			return 99999999999L;
		}
		long min = Long.MAX_VALUE;
		for (long i : al) {
			if (arr[(int) i] < min) {
				min = arr[(int) i];
			}
		}
		return min;
	}

}
 