package Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JudgeReviews {
	public static void main(String[] args) {
		
		String A ="pool_fridge_wifi";
		
		ArrayList<String> B = new ArrayList<String>();
		B.add("water_in_pool");
		B.add("pond_fridge_drink");
		B.add("pool_wifi_speed");
		
		JudgeReviews pc = new JudgeReviews();
		ArrayList<Integer> al = pc.solve(A, B);
		for(Integer i: al) {
			System.out.println(i);
		}
	}
	
	

	public  ArrayList<Integer> solve(String A, ArrayList<String> B){
		 
		insert(Arrays.asList(A.split("_")));
		List<Potato> pt = new ArrayList<Potato>();
		int index = 0;
		for(String s: B) {
			List<String> al= Arrays.asList(s.split("_"));
			int count = 0;
			for(String ss : al) {
				if(searchInTrie(ss)) {
					count++;
				}
			}
			pt.add(new Potato(count,index));
			index++;
		}
		
		Collections.sort(pt);
		ArrayList<Integer> res= new ArrayList<Integer>();
		for(int i = 0; i< pt.size(); i++) {
			res.add(pt.get(i).index);
		}
		return res;
	}
	
	
	public static void insert(List<String> words) {
		for(String s: words) {
			insertInTrie(s);
		}
	}
	
	static class Potato implements Comparable<Potato>{
		public int num;
		public int index;
		
		public Potato() {
		}
		
		public Potato(int num,int index) {
			this.num = num;
			this.index = index;
		}

		@Override
		public int compareTo(Potato o) {
			if(this.num < o.num)
				return +1;
			else if(this.num > o.num)
				return -1;
			else if(this.index > o.index)
				return +1;
			return -1;
		}
		
	}
	
	
	static final int ALPHABET_SIZE = 26; 
	
	static class TrieNode 
    { 
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
       
        // isEndOfWord is true if the node represents 
        // end of a word 
        boolean isEndOfWord; 
          
        TrieNode(){ 
            isEndOfWord = false; 
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
        } 
    }; 
    
    static TrieNode root = new TrieNode(); 
    
    
    static void insertInTrie(String key) 
    { 
        int level; 
        int length = key.length(); 
        int index; 
       
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
            if (pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode(); 
       
            pCrawl = pCrawl.children[index]; 
        } 
       
        // mark last node as leaf 
        pCrawl.isEndOfWord = true; 
    } 
    
    static boolean searchInTrie(String key) 
    { 
        int level; 
        int length = key.length(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
       
            if (pCrawl.children[index] == null) 
                return false; 
       
            pCrawl = pCrawl.children[index]; 
        } 
       
        return (pCrawl != null && pCrawl.isEndOfWord); 
    } 
    	
}
