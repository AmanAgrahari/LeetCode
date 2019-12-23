package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxChunksToMakeSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 0, 2, 3, 4 };
		int brr[] = {1,0,4,2,3,5};
		System.out.println(maxChunksToSorted(arr));
	}

	public static int maxChunksToSorted(int[] arr) {
		if (arr == null || arr.length == 1) {
			return 1;
		}
		int i;
		List<Pair> list = new ArrayList<Pair>();
		for (i = 0; i < arr.length; i++) {
			if (i != arr[i]) {
				list.add(new Pair(arr[i], i));
			} else {
				list.add(new Pair(i, arr[i]));
			}
		}
		System.out.println(list.toString());
		System.out.println("+++++++++++++++++++++++++++++++++");
		List<Pair> list1 = new ArrayList<Pair>();
		int j;
		while(true) {
			boolean didOverlap = false;
			Set<Integer> ss = new HashSet<>();
			for(i = 0; i < list.size(); ++i) {
				if(ss.contains(i)) {
					continue;
				}
				for(j = 0; j < list.size(); ++j) {
					if(overlap(list, i, j)) {
						if(i == j || ss.contains(j)) {
							continue;
						}
						ss.add(i);
						ss.add(j);
						didOverlap = true;
						Pair p = merge(list, i, j);
						list1.add(p);
						break;
					}
				}
				if(j == list.size()) {
					list1.add(list.get(i));
				}
			}
			System.out.println(list1.toString());
			if(!didOverlap) {
				return list1.size();
			}
			list = list1;
			list1 = new ArrayList<>();
		}
	}

	private static Pair merge(List<Pair> list, int i, int j) {
		Pair p1 = list.get(i);
		Pair p2 = list.get(j);
		return new Pair(Math.min(p1.i, p2.i),Math.max(p1.j, p2.j));
	}

	private static boolean overlap(List<Pair> list, int i, int j) {
		Pair p1 = list.get(i);
		Pair p2 = list.get(j);
		return (p1.i >= p2.i && p1.i <= p2.j) || (p2.i >= p1.i && p2.i <= p1.j);
	}

	static class Pair {
		public int i, j;

		Pair() {
		};

		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "(" + i + " " + j + ")";
		}
	}
}
