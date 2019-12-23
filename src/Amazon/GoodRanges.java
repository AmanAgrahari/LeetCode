package Amazon;

import java.util.Scanner;
import java.util.TreeSet;

public class GoodRanges {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		TreeSet<Long> treeSet = new TreeSet<Long>();
		long res = 0;
		while (q-- > 0) {
			long num = sc.nextLong();
			if(treeSet.contains(num)) {
				System.out.println(res);
				continue;
			}
			treeSet.add(num);
			Long low = treeSet.lower(num);
			Long high = treeSet.higher(num);
			res += (low == null && high == null) ? (1 + n) : (low == null) ? (high + num) : (high == null) ? (low + num) : 2 * num;
            System.out.println(res);
		}

	}
}
