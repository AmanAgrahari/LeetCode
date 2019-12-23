package ArraysLeet.Medium;

public class LongestTurbulentSubArray {
    public static void main(String[] args) {
        int arr[] = {9,4,2,10,7,8,8,1,9};
        int brr[] = {4,8,12,16};
        System.out.println(maxTurbulenceSize(arr));
    }


    public static int maxTurbulenceSize(int[] A) {


            if(A == null || A.length == 0){
                return 0;
            }
            if(A.length == 1){
                return 1;
            }

            int n = A.length;
            int i = 0;
            int max = 1;
            while (i < n-1){
                if(A[i] == A[i+1]){
                    i++;
                    continue;
                }
                int j = i+1;
                while (j+1 < n && isCheck(A,j)){
                    j++;
                }
                max = Math.max(j-i+1,max);
                i = j;
            }
            return max;
    }

    private static boolean isCheck(int[] A, int i) {
        return (A[i] > A[i - 1] && A[i] > A[i + 1]) || (A[i] < A[i - 1]) && (A[i] < A[i + 1]);
    }
}
