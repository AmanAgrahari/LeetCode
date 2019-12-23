package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class StringPermute1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	   public List<String> letterCasePermutation(String S) {
	          List<String> al = new ArrayList<>();
	        if(S == null || S.length() == 0){
	            return al;
	        }
	        letterCasePermutation(S.toCharArray(),0,al);
	        
	        return al;
	        
	    }
	    
	     public static void letterCasePermutation(char[] S , int i, List<String> al) {

			if(i == S.length) {
				al.add(unConvert(S));
				return;
			}
			if(S[i] >= '0' && S[i] <= '9') {
				letterCasePermutation(S, i+1,al);
			} else {
			    letterCasePermutation(covertToUpperCaseLetter(S,i), i+1, al);
			    letterCasePermutation(covertToUpperCaseLetter(S,i), i+1,al);
			}
		}
		
		public static char[] covertToUpperCaseLetter(char[] s , int i){
			if(s[i] >= 'a' && s[i] <= 'z') {
				s[i] = (char)(s[i]-32);	
			}
			else {
				s[i] = (char)(s[i]+32);	
			}
			return s;
		}
		public static char[] convert(String str) {
			return str.toCharArray();
		} 
		public static String unConvert(char[] str) {
			return String.valueOf(str);
		}

}
