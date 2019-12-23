package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

	public static void main(String[] args) {

		int nums[] = { 1, 1, 1, 3, 3, 2, 2, 2 };
		 List<Integer> al = majorityElement(nums);
		 System.out.println(al.toString());

		//System.out.println(al.get(1));

	}

	public static List<Integer> majorityElement(int[] nums) {
		List<pair> al = new ArrayList<pair>();
		al.add(new pair(0, 0));
		al.add(new pair(0, 0));
		int i;
		for (i = 0; i < nums.length; i++) {
			int j;
			for (j = 0; j < 2; j++) {
				if (al.get(j).element == nums[i]) {
					al.get(j).count += 1;
					break;
				}
			}
			// if not present
			if (j == 2) {
				int k;
				for (k = 0; k < 2; k++) {
					if (al.get(k).count == 0) {
						al.get(k).element = nums[i];
						al.get(k).count = 1;
						break;
					}
				}
				// if element is not zero yeh bhi ho sakta hai
				if (k == 2)
					for (k = 0; k < 2; k++)
						al.get(k).count -= 1;
				}
			}
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(i = 0; i < 2; i++) {
			int c = 0;
			for(int m= 0; m < nums.length; m++) {
				if(nums[m] == al.get(i).element) {
					c++;
				}
			}
			if(c > nums.length/3) {
				res.add(al.get(i).element);
			}
		}
		return res;
	}

	static class pair {
		public int element;
		public int count;

		public pair(int element, int count) {
			super();
			this.element = element;
			this.count = count;
		}

		@Override
		public String toString() {
			return "pair [element=" + element + ", count=" + count + "]";
		}

	}
}
