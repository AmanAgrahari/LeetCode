import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairOfSongsDurationDivisible60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {418,204,77,278,239,457,284,263,372,279,476,416,360,18};
		/*
		 * (time[0] = 30, time[2] = 150): total duration 180 (time[1] = 20, time[3] =
		 * 100):total duration 120 (time[1] = 20, time[4] = 40): total duration 60
		 */

		System.out.println(numPairsDivisibleBy60(arr));
	}

	public static int numPairsDivisibleBy60(int[] time) {
		for (int i = 0; i < time.length; i++) {
			time[i] = (time[i] % 60);
		}
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int c = 0;
		for (int i = 0; i < time.length; i++) {
			if (map.containsKey((60 - time[i]))) {
				ans += map.get(60 - time[i]);
			}
			map.putIfAbsent(time[i], 0);
			map.put(time[i], map.get(time[i]) + 1);
		}

		if (map.get(0) != null) {
			if (map.get(0) >= 1) {
				int k = (map.get(0) * (map.get(0) - 1)) / 2;
				ans = ans + k;
			} else {
				ans = ans + map.get(0);
			}
		}

		return ans;
	}
}
