package ArraysLeet;

import java.util.HashMap;

public class XKindOfDeck {

	public static void main(String[] args) {
		int arr[] = {1,1,1,1,2,2,2,2,2,2 };
		//System.out.println(hasGroupsSizeX(arr));
	}

	public static  boolean hasGroupsSizeX(int[] deck) {
		int i;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (i = 0; i < deck.length; i++) {
			map.putIfAbsent(deck[i], 0);
			map.put(deck[i], map.get(deck[i]) + 1);
		}
		
		int min = Integer.MAX_VALUE;
        for (int value : map.values()) {
            min = Math.min(min, value);
        }
        for(i =2; i<=min;i++) {
        	 boolean b = true;
             for (int value : map.values()) {
                 if (value % i != 0) {
                     b = false;
                     break;
                 }
             }
             if(b) {
            	 return true;
             }
        }
       
		return false;
	}
}
