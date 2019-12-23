package ArraysLeet.Medium;

public class CorporateFlightBookings {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        corpFlightBookings(arr,n);
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int res[] = new int[n];
        int i;
        for(int [] booking:bookings){
            int left  = booking[0]-1;
            int right = booking[1]-1;
            int seat = booking[2];
            updateArray(res ,left,right,seat);
        }
        printArray(res);
        return res;
    }

    public  static void updateArray(int res[],int i, int j,int val){
        int k;
        res[i] = res[i]+ val;
        if(j+1 < res.length)
            res[j+1] = res[j+1] -val;
    }
    public  static void printArray(int res[]){
        for(int i = 1; i < res.length;i++){
            res[i] = res[i-1] + res[i];
        }
        System.out.println();
    }
}
