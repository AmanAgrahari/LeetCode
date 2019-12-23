package ArraysLeet.Medium;

import java.util.Arrays;
public class GlobalAndLocalInversion {
    public static void main(String[] args) {

        int A[] = {1,0,2};
        System.out.println(isIdealPermutation(A));
    }
    public static boolean isIdealPermutation(int[] A) {

        int k = localInversion(A);
        int p = globalInversion(A);
        return k==p;
    }

    private static int localInversion(int[] a) {
        int i,c = 0;
        for(i = 0; i+1 < a.length; i++){
            if(a[i] > a[i+1]){
                c++;
            }
        }
        return c;
    }

    private static int globalInversion(int[] a) {
        return  mergeSortAndCount(a,0,a.length-1);
    }



    private static int mergeAndCount(int[] arr, int l, int m, int r)
    {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray

        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    // Merge sort function
    private static int mergeSortAndCount(int[] arr, int l, int r)
    {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }
}