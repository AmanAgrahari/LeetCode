package ArraysLeet.Medium;

import java.util.HashMap;

public class SubArraySumDivisibleByK {

	public static void main(String[] args) {

		int arr[] = {-1,2,9 };
		int K = 2;
         System.out.println(subarraysDivByK(arr, K));
	}

	public static int subarraysDivByK(int[] arr, int K) {

		/*
		 * we will be calculating cumulative sum because we can tell the cumulative sum
		 * in a range
		 eg : 4 , 5 ,0 , -2, -3 , 1 (so cumulative sum =)
	    C[] = 4 , 9 ,9 ,  7 , 4 , 5
		     So we have to find a sum for range 2 to 4
		      s = C[j] - C[i-1] ; i.e C[4] - C[1] = 9 - 4 = 5
		      step 1 : what should i subtract from 4 so that it should be divisible by 5 i.e 4
		      step 2 : what should i subtract from 9 so that it should be divisible by 5 i.e 4,9
		      step 3 : what should i subtract from 9 so that it should be divisible by 5 i.e 4,9
		      step 4 : what should i subtract from 7 so that it should be divisible by 5 i.e 2,7
		      step 5 : what should i subtract from 4 so that it should be divisible by 5 i.e 4
		      step 6 : what should i subtract from 5 so that it should be divisible by 5 i.e 5,0
		      
		      So now every number can be written in form of AP i.e (Kn + 0 to 4)
		      in this example (5n+0 or 5n+1 or 5n+2 or 5n+3 or 5n+4)% k = remainder
		      now we will do remainder
		      C[] = 4 , 4 , 4, 2 , 4 , 0
		      now its a handshake problem i.e n(n-1)/2
		      count of 4  = 4(4-1)/2 = 2*3 = 6
		 * 
		 */
		int i;
		int c[] = new int[arr.length];
		c[0] = ((arr[0] % K) + K)% K;
		for (i = 1; i < arr.length; i++) {
			arr[i]= (arr[i] + arr[i - 1]);
			c[i] = ((arr[i] % K) + K) % K;
			System.out.println(c[i]);
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ans = 0;
		for (i = 0; i < c.length; i++) {
			if(map.containsKey(c[i])) {
			ans+= map.getOrDefault(c[i],0);	
			}
			map.put(c[i], map.getOrDefault(c[i], 0)+1);
		}
		return ans + map.getOrDefault(0, 0);
	}

}
