package ArraysLeet;

import java.util.HashSet;

import javax.print.attribute.standard.Finishings;

public class KdiffPairs {

	public static void main(String[] args) {
	
		int arr [] = {3, 1, 4, 1, 5};
		int k = 0;
		
		System.out.println(findPairs(arr,k));

	}
	
	public static int findPairs(int[] nums, int k) {
		int i;
		HashSet<Integer> set = new HashSet<Integer>();
		for(i = 0 ; i< nums.length; i++) {
			set.add(nums[i]);
		}
		HashSet<Pair> pair = new HashSet<>();
		int c = 0;
		
		for(int j=0 ;j < nums.length; j++) {
			 {
				pair.add(new Pair(nums[j],nums[j]+k,j));
			 }
			 {
				pair.add(new Pair(nums[j]-k,nums[j],j));
			}
		}
		for(Pair pa: pair) {
			System.out.println(pa.i  + "  " +pa.j);
		}
        return pair.size();
    }
	
	
	static class Pair{
		int i;
		int j;
		int index;
		Pair(int i,int j,int index){
			this.i = i;
			this.j = j;
			this.index =index;
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
			Pair other = (Pair) obj;
			if (i == other.i && j == other.j && index!= other.index)
				return true;
			return false;
		}
	}

}
