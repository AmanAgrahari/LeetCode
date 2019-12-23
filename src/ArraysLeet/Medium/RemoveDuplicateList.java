package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateList {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		
		List<Integer> first = new ArrayList<Integer>();
		first .add(1);
		first .add(2);
		first .add(3);

		List<Integer> second = new ArrayList<Integer>();
		second .add(4);
		second .add(5);
		second .add(6);

		List<Integer> third = new ArrayList<Integer>();
		third .add(1);
		third .add(2);
		third .add(3);

		List<Integer> fourth = new ArrayList<Integer>();
		fourth .add(7);
		fourth .add(8);
		fourth .add(9);

		List<Integer> fifth = new ArrayList<Integer>();
		fifth .add(4);
		fifth .add(5);
		fifth .add(6);
		
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		list.add(fifth);
		removeDuplicates(list);
	}

	private static void removeDuplicates(List<List<Integer>> list) {
		int i,j;
		int arr[] = new int[list.size()];
		for(i = 0; i < list.size(); i++) {
			List<Integer> al = list.get(i);
			for(j = i+1; j < list.size(); j++) {
				List<Integer> bl = list.get(i);
				compare(al,bl,arr,j);
			}
		}
		
		for(int k = 0 ; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
	}

	private static void compare(List<Integer> al, List<Integer> bl, int[] arr,int j) {
		//System.out.println("comp");
		int i = 0;
		if(al.size() == bl.size()) {
			for(i = 0; i < al.size(); i++) {
				if(al.get(i)!=bl.get(i)) {
					break;
				}
			}	
		}
		
		if(i == al.size()) {
			arr[j]++;
		}
	}

}
