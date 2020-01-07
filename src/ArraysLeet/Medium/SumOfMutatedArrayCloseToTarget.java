package ArraysLeet.Medium;

public class SumOfMutatedArrayCloseToTarget {
    public static void main(String[] args) {

        int arr[] = {4,9,3};
        int target = 10;
        System.out.println(findBestValue(arr,target));
    }
    public static int findBestValue(int[] arr, int target) {

        int i,sum = 0;
        for(i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        if(sum < target){
            return target;
        }
        int l = 0, r = sum;
        while(l < r) {
            int m = (l+r)/2;
            if(eval(m, arr, target) <= eval(m+1, arr, target))
                r = m;
            else
                l = m+1;
        }

        return l;
    }

   static int eval(int m, int[] arr, int target) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += Math.min(arr[i], m);
        }
        return Math.abs(sum-target);
    }
}
