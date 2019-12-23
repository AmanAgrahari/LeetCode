package ArraysLeet.Medium;

import java.util.*;

public class LongestFibonacciSubsequence {
    public static void main(String[] args) {
        int [] arr = {2,4,7,8,9,10,14,15,18,23,32,50};
        //1,2,3,5,8
        int [] brr = {1,3,7,11,12,14,18};
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int i,j,max = 0;
        Set<Integer> al = new HashSet<>();
        for(i = 0; i < arr.length; i++){
            al.add(arr[i]);
        }
        for(i = 0; i < arr.length; i++){
            for(j = i+1; j < arr.length; j++){
                int a = arr[i];
                int b = arr[j];
                int c = 2;
                while(al.contains(a+b)){
                    c++;
                    int temp = a;
                    a = b;
                    b = temp + a;
                }
                if (c > 2 && max < c ){
                    max = c;
                }
            }
        }
        return max;
    }
}
