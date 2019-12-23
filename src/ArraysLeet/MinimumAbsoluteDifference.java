package ArraysLeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> outputList = new ArrayList<List<Integer>>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int i;
        for(i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i]-arr[i-1]) < min){
                min = Math.abs(arr[i-1]-arr[i]);
            }
        }

        for(i = 1; i < arr.length; i++) {
            List<Integer> outputSubList = new ArrayList<Integer>();
            if(Math.abs(arr[i]-arr[i-1]) == min){
                outputSubList.add(arr[i-1]);
                outputSubList.add(arr[i]);
            }

            if(!outputSubList.isEmpty()) {
                outputList.add(outputSubList);
            }
        }
        return outputList;
    }
}
