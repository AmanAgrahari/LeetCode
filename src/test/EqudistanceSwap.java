package test;

import java.util.*;

public class EqudistanceSwap{

    public static int findTheswappedIndex(int [] arr){

        int n=arr.length;

        int first_start=1;
        int first_end=n/2;
        int second_start=n/2+1;
        int second_end=n-2;
        
        while(first_start<=first_end){

            int mid=(first_start+first_end)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else
                first_end=mid-1;
        }

        while(second_start<=second_end){

            int mid=(second_start+second_end)/2;
            if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1])
                return mid;
            else
                second_end=mid-1;
        }

        return -1;
    }

    public static void main(String [] args){

        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        if(n<=1)
            return;
        int [] arr =new int[n];

        for(int i=0;i<n;++i)
            arr[i]=sc.nextInt();

        if(arr[0]>arr[1])
            System.out.println("swapped indexes are: "+1+" "+(arr.length));

        else{
            int findIndex=findTheswappedIndex(arr);
            if(findIndex!=-1)
                System.out.println("swapped indexes are: "+(findIndex+1)+" "+(arr.length-findIndex));
            else
                System.out.println("swapped indexes are not present: ");
        }

    }

}