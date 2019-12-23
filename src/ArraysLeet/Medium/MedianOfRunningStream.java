package ArraysLeet.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfRunningStream {

    public static double[] getMedians(int[] array){
        ///max-Heap
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // change comparison to put biggest element on top
                return -1* a.compareTo(b);
            }
        });
        //min-Heap
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        double [] medians = new double[array.length];
        for(int i = 0; i <array.length; i++){
            int number = array[i];
            addNumber(number,lowers,highers);
            rebalance(lowers,highers);
            medians[i]= getMedian(lowers,highers);
        }
        return medians;
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if(lowers.isEmpty() || number < lowers.peek()){
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers:lowers;

        if(biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers:lowers;
        if(biggerHeap.size() == smallerHeap.size()){
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }



    public static void main(String[] args) {

    }
}
