package ArraysLeet.Medium;

public class PartitionArrayIntoDisjointInterval {
    public static void main(String[] args) {

        int arr[] = {90,47,69,10,43,92,31,73,61,97};
        System.out.print(partitionDisjoint(arr));
        String s = "aman";
    }
    public static int partitionDisjoint(int[] A) {
        int i;
        for(i = 1; i < A.length; i++){
            A[i] = Math.max(A[i-1],A[i]);
        }
        for(i = 1; i < A.length; i++){
            if(A[i] != A[i-1]){
                break;
            }
        }
        if(i == A.length){
            return 1;
        }

        int max = A[0];
        for(i = 1; i < A.length; i++){
            if(A[i] > max){
                return i;
            }
        }
        return 0;
    }

}
