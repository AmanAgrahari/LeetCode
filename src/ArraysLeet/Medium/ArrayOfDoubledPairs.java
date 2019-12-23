package ArraysLeet.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        int arr[] = {0,0};
        System.out.println(canReorderDoubled(arr));
    }
    public static boolean canReorderDoubled(int[] A) {
        int i;
        Map<Integer,Integer> map = new HashMap<>();
        for(i = 0; i < A.length; i++){
            map.putIfAbsent(A[i],0);
            map.put(A[i],map.get(A[i])+1);
        }
        int c = 0;
        Arrays.sort(A);
        for(i = 0; i < A.length ;i++){
            if(A[i] < 0){
                continue;
            } else {
                break;
            }
        }
      //  System.out.println(i);
        for(int j  = i - 1; j >=0 ; j--){
            Integer p = map.get(A[j]);
            Integer p1 = map.get(2*A[j]);
            if(p!=null && p1!=null && p > 0 && p1 > 0){
                map.put(A[j],map.get(A[j]) - 1);
                map.put(2*A[j],map.get(2*A[j]) - 1);
                c++;
            }
        }
        for(; i < A.length; i++){
            Integer p = map.get(A[i]);
            Integer p1 = map.get(2*A[i]);
            //System.out.println(p + " " + p1);
            if(p!=null && p1!=null && p > 0 && p1 > 0){
                map.put(A[i],map.get(A[i]) - 1);
                map.put(2*A[i],map.get(2*A[i]) - 1);
                c++;
            }
        }
        System.out.println(c);
        if(2*c==A.length){
            return true;
        }
        return false;
    }
}
