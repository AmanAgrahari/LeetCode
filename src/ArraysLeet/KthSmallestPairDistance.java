package ArraysLeet;

import java.util.Arrays;

public class KthSmallestPairDistance {
    public static void main(String[] args) {
        int arr[] = {1,3,1};

        System.out.println(smallestDistancePair(arr,1));

       // System.out.println(foobar(3,new int[] {1,2,3,4,5,6}));
    }


    /*
    returns number of pairs having difference <= x
     */
    static int  foobar(int x, int [] nums) {
        int left = 0;
        int reight = left+1;
        int res = 0;
        while (reight < nums.length && left < reight){
            if(nums[reight] - nums[left] <= x){
                res+=(reight -left);
                reight++;
            } else {
                left++;
            }
        }
        return res;
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0, h = nums[nums.length - 1] - nums[0], ans = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int t = foobar(m, nums);
            System.out.println(t);
            if(t >= k) { // T
                ans = m;
                h = m - 1;
            } else { // F
                l = m + 1;
            }
        }
        return ans;
    }
}