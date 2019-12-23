package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSequence {
    public static void main(String[] args) {
        String s  = "dsahjpjauf";
        String words [] = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq(s,words));
    }

    public static int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int i,j;
        for(i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new ArrayList<Integer>());
            map.get(S.charAt(i)).add(i);
        }
        int index [] = new int [26];
        int count = 0;
        for(i = 0; i < words.length; i++){
            String p = words[i];
            int prevInd = -1;
            jj:
            for(j = 0; j < p.length(); j++){
                List<Integer> list =  map.get(p.charAt(j));
                if(list == null) {
                    break;
                }
                char ch = p.charAt(j);
                if(index[ch - 'a'] >= list.size()) {
                    break;
                }
                while(list.get(index[ch - 'a']) < prevInd) {
                    index[ch - 'a']++;
                    if(index[ch - 'a'] >= list.size()) {
                        break jj;
                    }
                }
                int ind = list.get(index[ch - 'a']);
                index[ch - 'a']++;
                if(ind > prevInd) {
                    prevInd = ind;
                } else {
                    break;
                }
            }
            count += (j == p.length() )  ? 1 : 0;
            for(j = 0; j < 26; ++j) {
                index[j] = 0;
            }
        }
        return count;
    }
}
