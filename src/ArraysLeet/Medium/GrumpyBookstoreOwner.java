package ArraysLeet.Medium;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {

        //int customers[] = {9,10,4,5};
        //int grumpy [] =   {1,0,1,1};
        //int customers[] = {1,0,1,2,1,1,7,5};
        //int grumpy [] =   {0,1,0,1,0,1,0,1};

       int customers[] = {10,4};
        int grumpy [] =   {0,1};
        int X = 2;
        System.out.println(maxSatisfied(customers,grumpy,X));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int i;
        for(i = 0 ; i < customers.length; i++){
            if(grumpy[i] == 1){
                continue;
            }
            else{
                res+=customers[i];
                customers[i] = 0;
            }
        }
        int max_subarray = 0;
        for(i=0;i<X; i ++) {
            if(grumpy[i]==1) {
                max_subarray += customers[i];
            }
        }
        int  j=X, tmp_max_subarray = max_subarray;
        i = 0;
        while (j<grumpy.length) {
            if(grumpy[j]==1) {
                tmp_max_subarray += customers[j];
            }
            if(grumpy[i]==1) {
                tmp_max_subarray -=  customers[i];
            }
            if (tmp_max_subarray > max_subarray) {
                max_subarray = tmp_max_subarray;
            }
            j++;
            i++;
        }
        return res+max_subarray;
    }
}
