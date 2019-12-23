package ArraysLeet.Medium;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        int arr[] = {6,0,8,2,1,5};
        System.out.println(maxWidthRamp(arr));
    }
    public static int maxWidthRamp(int[] A) {
        int i,j;
        int max = 0;

        if(A.length == 0)
            return 0;

        int leftMinIndex [] = new int[A.length];
        int rightMaxIndex [] = new int[A.length];

        leftMinIndex[0] = 0;
        for(i = 1; i < A.length; i++){
            leftMinIndex[i] = (A[i] > A[leftMinIndex[i-1]]) ? leftMinIndex[i-1]:i;
        }
        rightMaxIndex[A.length-1] = A.length-1;
        for(i = A.length-2; i >= 0; i--){
            rightMaxIndex[i] = (A[i] > A[rightMaxIndex[i+1]])  ? i :rightMaxIndex[i+1];
        }

        i = 0; j = 0;
        while(i < A.length && j < A.length){
            if(A[leftMinIndex[i]]<= A[rightMaxIndex[j]]){
                max = Math.max(max,j-i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }
}
