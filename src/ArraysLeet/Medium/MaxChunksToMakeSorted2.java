package ArraysLeet.Medium;

import java.util.*;

public class MaxChunksToMakeSorted2 {
    public static void main(String[] args) {

        int arr[] = {1,1,0,0,1};
        System.out.println(maxChunksToSorted(arr));
    }
    public static int maxChunksToSorted(int[] arr) {

        int brr[] = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        int i;
        for(i = 0; i < arr.length; i++){
            map.putIfAbsent(arr[i],new LinkedList<>());
            map.get(arr[i]).add(i);
        }
        int max = -1;
        int ans = 0;
        for (i = 0; i < brr.length; ++i) {
            if(brr[i] == max) {
                map.get(max).poll();
            }
            max = Math.max(max, brr[i]);
         //   System.out.println(i + " " + map.get(max).peek());
            if (i == map.get(max).peek()){
                map.get(max).poll();
                ans++;
                max = -1;
            }
        }
        return ans;
    }
}
