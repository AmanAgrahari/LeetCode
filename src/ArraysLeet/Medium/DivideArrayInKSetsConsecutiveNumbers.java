package ArraysLeet.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class DivideArrayInKSetsConsecutiveNumbers {
    public static void main(String[] args) {
        int nums [] = {1,2,3,3,4,4,5,6};
        int k = 4;
        System.out.println(isPossibleDivide(nums,k));
    }
    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length % k != 0) return false;
        Arrays.sort(nums);

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num:nums){
            if(map.get(num) == 0) continue;
            else {
                for(int j = 0; j < k; j++){
                   if(map.getOrDefault(num + j,0) > 0){
                      map.put(num+j,map.get(num + j)-1);
                   } else {
                       return false;
                   }
                }
            }
        }
        return true;
    }
}
