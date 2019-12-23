package ArraysLeet.Medium;

public class MaximumSwap {
    public static void main(String[] args) {
        int n =  972;
       System.out.println(greatestWithOneSwap(n));
    }

    public static int greatestWithOneSwap(int n){
        char[] A = String.valueOf(n).toCharArray();
        int index [] = new int[10];
        int i,j;
        for(i = 0; i < 10; i++){
            index[i] = -1;
        }
        for(i = 0; i < A.length; i++){
                index[A[i]- '0'] = i;
        }
        for(i = 0; i < A.length; i++){
            for(j = 9; j > 0; j--){
                if(index[j] != -1 && j > (int)(A[i] - '0') && index[j] > i) {
                    A[index[j]] = A[i];
                    A[i] = (char)(j + '0');
                    return Integer.parseInt(new String(A));
                }
            }
        }
        return Integer.parseInt(new String(A));
    }
}
