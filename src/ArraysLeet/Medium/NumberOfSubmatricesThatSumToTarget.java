package ArraysLeet.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {

        int a[] = {0, 1, 0};
        int arr[][] = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int k = 0;
        //System.out.println(numberOfSubarrayEqualtoK(a, k));
        System.out.println(numSubmatrixSumTarget(arr, k));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int i, j, k;
        int n = matrix.length;
        int m = matrix[0].length;
        for (i = 0; i < m; i++) {
            int A[] = new int[n];
            for (j = i; j < m; j++) {
                for (k = 0; k < n; k++) {
                    A[k] += matrix[k][j];
                }
                count += numberOfSubarrayEqualtoK(A, k);
            }
            A = new int[n];
        }
        return count;
    }


    public static int numberOfSubarrayEqualtoK(int A[], int k) {

        // range sum   k = C[j] - C[i-1]
        // c[i-1] = C[j] - k;
        for(int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + " ");
        }
        int B[] = new int[A.length];
        B[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] + A[i];
        }
        int c = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (B[i] == k) {
                c++;
            } else if (map.containsKey(B[i] - k)) {
                c++;
            }
            map.putIfAbsent(B[i], 0);
            map.put(B[i], map.get(B[i]) + 1);
        }
        System.out.println(c);
        return c;
    }
}
