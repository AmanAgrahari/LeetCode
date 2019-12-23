package ArraysLeet;

public class BeautifulArrangement2 {
    public static void main(String[] args) {

        constructArray(3,2);
    }

    public static void constructArray(int n, int k) {

        int arr[] = new int[n];
        int i = 0;
        int j = 0;
        int p = k + 1;
        while (j < p) {
            arr[i] = j+1;
            if(i+1 < arr.length)
            arr[i + 1] = p;
            i= i + 2;
            j++;
            p--;
        }

        for(i = k+1; i < arr.length; i++){
            arr[i] = i+1;
        }
        for(i = 0; i < arr.length; i++){
         System.out.print(arr[i]+ " ");
        }
    }
}
