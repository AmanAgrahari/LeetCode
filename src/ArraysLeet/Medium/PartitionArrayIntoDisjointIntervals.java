package ArraysLeet.Medium;

public class PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {
        int A[] = {5, 0, 3, 8, 6};
        int B[] = {1, 1, 1, 0, 6, 12};
        System.out.println(
             new PartitionArrayIntoDisjointIntervals().partitionDisjoint(A)
        );
        System.out.println(
             new PartitionArrayIntoDisjointIntervals().partitionDisjoint(B)
        );
    }

    public int maxInRange(int i, int j, int [] A) {
        int x;
        int in = i;
        for(x = i + 1; x <= j; ++x) {
            if(A[x] > A[in]) {
                in = x;
            }
        }
        return in;
    }

    public int usseChotaSabseDoor(int [] A, int in, int x) {
        int i, m;
        for(i = A.length - 1; i >= in; --i) {
            if(A[i] < x) {
                return i;
            }
        }
        return -1;
    }

    public int partitionDisjoint(int[] A) {
         int l = 0, r = 0, i;
         while(true) {
             int maxI = maxInRange(l, r, A);
             int usse = usseChotaSabseDoor(A, r, A[maxI]);
             if(usse == -1) {
                 return (r + 1);
             }
             r = usse;
             l = maxI + 1;
         }
    }
}
