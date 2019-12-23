package ArraysLeet.Medium;

public class MaximumSumCircularSubArray {
    public static void main(String[] args) {
    int arr[] = {5,-3,5,5,-3,5};
    System.out.print(maximumSum(arr));
    }

    public static int maximumSum(int [] A){
        int best_sum = A[0];
        int current_sum = A[0];
        int i;
        for (i = 1; i < A.length; i++){
            current_sum = Math.max(Integer.MIN_VALUE, current_sum + A[i]);
            best_sum = Math.max(best_sum, current_sum);
        }

        int left [] = new int[A.length];
        left[0] = A[0];
        for (i = 1; i < left.length; i++){
            left[i] = left[i-1] + A[i];
        }

        for (i = 1; i < left.length; i++)
            left[i] = Math.max(left[i-1],left[i]);

        int right [] = new int[A.length];
        right[right.length-1] = A[A.length -1];

        for(i = right.length -2; i >=0; i--){
            right[i] = right[i+1] + A[i];
        }
        for(i = right.length -2; i >=0; i--){
            right[i] = Math.max(right[i+1] , right[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(i = 0; i < A.length; i++){
            if(i == 0){
                ans = Math.max(ans,left[i]);
            } else if(i+1 == A.length){
                ans = Math.max(ans,right[i]);
            } else if(i-1 >=0 && i+1 < A.length){
                ans  = Math.max(ans,left[i-1]+right[i+1]);
            }
        }
        ans = Math.max(ans,best_sum);
        return ans;
    }
}
