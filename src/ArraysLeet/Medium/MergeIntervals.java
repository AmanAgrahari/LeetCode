package ArraysLeet.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

	public static void main(String[] args) {

		int[][] arr = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int brr[] = {4,8};
		arr = insert(arr,brr);
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	public static  int[][] insert(int[][] intervals, int[] newInterval) {
		int n = intervals.length;
		int arr[][] = new int[n+1][intervals[0].length];
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals[0].length; j++) {
				arr[i][j] = intervals[i][j];
			}
		}
		arr[n][0]= newInterval[0];
		arr[n][1] = newInterval[1];	
		arr = merge(arr);
		return arr;
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
			return intervals;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] s1, int[] s2) {
				if (s1[0] > s2[0])
					return 1;
				else if (s1[0] < s2[0])
					return -1;
				else {
					if (s1[1] < s2[1])
						return 1;
					else if (s1[1] > s2[1])
						return -1;
					else
						return 0;
				}
			}
		});
		int i, j;
		int k = 0;
		for (i = 0; i < intervals.length; i++) {
			if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
				int first = Math.min(intervals[i][0], intervals[i + 1][0]);
				int second = Math.max(intervals[i][1], intervals[i + 1][1]);
				intervals[i + 1][0] = first;
				intervals[i + 1][1] = second;
				intervals[i][0] = 0;
				intervals[i][1] = 0;
				k++;
			}
		}
		int ret[][] = new int[intervals.length - k][2];
		int c = 0;
		for (j = 0; j < intervals.length; j++) {
			if ((intervals[j][0] == 0 && intervals[j][1] != 0) || (intervals[j][0] != 0 && intervals[j][1] == 0)
					|| (intervals[j][0] != 0 && intervals[j][1] != 0)) {
				ret[c][0] = intervals[j][0];
				ret[c][1] = intervals[j][1];
				c++;
			}
		}
		if (k != 0) {
			return ret;
		}
		return intervals;
	}

}
