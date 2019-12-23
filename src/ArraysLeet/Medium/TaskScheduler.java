package ArraysLeet.Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
    char p [] = {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'D'};
    int n = 2;
    System.out.print(leastInterval(p,n));
    }
    public static int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) {
            return 0;
        }
        int[] hash = new int[27];
        for (char x : tasks) {
            hash[x - 'A']++;
        }
        char arr[] = new char[100000];
        Arrays.fill(arr, '1');
        int i;
        while(true) {
            char mc = ' ';
            int maxF = -1;
            for (char x = 'A'; x <= 'Z'; ++x) {
                if (hash[x - 'A'] > maxF) {
                    maxF = hash[x - 'A'];
                    mc = x;
                }
            }
            if(maxF == 0) {
                break;
            }
            hash[mc - 'A'] = 0;
            int ind = 1;
            for (i = 0; i < maxF; ++i) {
                if (arr[ind] == '1') {
                    arr[ind] = mc;
                    ind += n + 1;
                } else {
                    ind++;
                    i--;
                }
            }
        }
        for(i = arr.length - 1; i >= 0; --i) {
            if(arr[i] != '1') {
                break;
            }
        }
        return i;
    }
}
