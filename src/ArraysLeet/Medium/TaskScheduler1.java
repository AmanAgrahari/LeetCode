package ArraysLeet.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskScheduler1 {
    public static void main(String[] args) {
        char p [] = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.print(leastInterval(p,n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int hash [] = new int[26];
        int max  = 0;
        for(char c: tasks){
            hash[c-'A']++;
        }
      Arrays.sort(hash);
        int time = 0;
        while(hash[25] > 0 ){
            int i = 0;
            while(i < n){
                if(hash[25] == 0)
                    break;
                if(i < 26 && hash[25 - i] > 0)
                    hash[25- i]--;
                time++;
                i++;
            }
            Arrays.sort(hash);
        }
        return time;
    }
}
