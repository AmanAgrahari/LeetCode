package ArraysLeet.Medium;

import java.util.TreeMap;

public class AdvantageShuffle {
    public static void main(String[] args) {

        int arr[] = {12,24,8,32};
        int brr[] = {13,25,32,11};
        advantageCount(arr,brr);
    }
    public static int[] advantageCount(int[] A, int[] B) {

        int i;
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        for(i = 0; i < A.length; i++){
            tree.putIfAbsent(A[i], 0);
            tree.put(A[i],tree.get(A[i])+1);
        }

        int C[] = new int[A.length];
        for( i = 0; i < B.length; i++){
            Integer k = tree.higherKey(B[i]);
            if(k == null){
                int n = tree.firstKey();
                C[i] = n;
            } else {
                C[i] = k;
            }
            tree.put(C[i],tree.get(C[i])-1);
            if((tree.get(C[i]) == 0)){
                tree.remove(C[i]);
            }
        }
        printArray(C );
        return C;
    }

    public static void printArray(int c[]){
        int i;
        for (i = 0; i < c.length; i++){
            System.out.print(c[i] + "  ");
        }
        System.out.println();
    }
}
