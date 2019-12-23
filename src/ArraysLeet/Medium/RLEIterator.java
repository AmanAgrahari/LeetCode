package ArraysLeet.Medium;

class RLEIterator {

    int[] arr;
    int id = 0;
    public RLEIterator(int[] A) {
        arr = A;
    }
    
    public int next(int n) {
        if(id == arr.length) return -1;

        while(arr[id] < n){
            n -= arr[id];
            id += 2;
            if(id == arr.length) return -1;
        }
        arr[id]-=n;
        return arr[id+1];
    }
    public static void main(String[] args) {
        int A[] = {784,303,477,583,909,505};
        RLEIterator obj = new RLEIterator(A);
        System.out.print (obj.next(2));
        System.out.print (obj.next(1));
        System.out.print (obj.next(1));
        System.out.print (obj.next(2));
    }
}
