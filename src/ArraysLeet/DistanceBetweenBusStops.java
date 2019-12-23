package ArraysLeet;

public class DistanceBetweenBusStops {
    public static void main(String[] args) {

        int dist[] = {1,2,3,4};
        System.out.println(distanceBetweenBusStops(dist,0,1));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = Math.min(start,destination);
        int max = Math.max(start,destination);

        int totalSum = 0;
        int i;
        for(i = 0; i < distance.length; i++){
            totalSum+=distance[i];
        }
        int sum = 0;
        for(i = min; i < max; i++){
            sum+=distance[i];
        }
        return Math.min(sum,totalSum-sum);
    }
}
