package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class BestTimeToBuyAndSellStock3 {

	public static void main(String[] args) {
		int arr[] = {1,2,4,2,5,7,2,4,9,0};
		int brr[] = {7,1,5,3,6,4};
		System.out.println(maxProfit_2(brr));
	}

	public static int maxProfit(int[] arr) {

		if(arr == null || arr.length == 0 || arr.length == 1) {
			return 0;
		}
		if(arr.length == 1) {
			return arr[0];
		}
		int i = 0;
		int j = i+1;
		int n = arr.length;
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(i < n && j < n) {
			if(arr[i] == arr[j]) {
				j++;
				continue;
			}
			if(arr[i] < arr[j]) {
				while(j < n && arr[i] <= arr[j] && arr[j] > arr[j-1]) {
					j++;
				}
				al.add(arr[j-1] - arr[i]);
				System.out.println("if  " + arr[i] + " " +  arr[j-1]);
				i = j-1;
			} else {
				System.out.println("else " +  arr[i] + "  " + arr[j]);
				i++;
				j++;
			}
		}

		Collections.sort(al);
		//System.out.println(al.toString());
		if(al.size() >= 2) {
			return al.get(al.size()-1) + al.get(al.size()-2);
		}
		if(al.size() == 1) {
			return al.get(0);
		}
		return 0;
	}


	public static  int maxProfit_2(int[] prices) {
		int profit = 0;
		int sub = 0;
		for(int i = prices.length-1;i > 0 ;i--) {
			sub= Math.subtractExact(prices[i], prices[i-1]);
			if(sub > 0) {
				profit+=sub;
			}
		}
		return profit;
	}
}
