package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class StringPermute {

	static List<String> al = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		
		List<String> al = new ArrayList<String>();
		letterCasePermutation(s,0,al);
		System.out.println(al);
	}
		
	public static String covertToUpperCaseLetter(String s , int i){
		char ch = s.charAt(i);
		String str = "";
		for(int j = 0; j < s.length();j++) {
			if(i ==j) {
				str+= (char)(s.charAt(j) - 32);
			} else {

				str+=s.charAt(j);
			}
		}
		return str;
	}

	public static void letterCasePermutation(String S , int i,List<String> al) {

		if(i == S.length()) {
			al.add(S);
			return;
		}
		if(S.charAt(i) >= '0' && S.charAt(i) <= '9') {
			letterCasePermutation(S, i+1,al);
		}
		letterCasePermutation(covertToUpperCaseLetter(S,i), i+1,al);
		letterCasePermutation(S, i+1,al);
	}
	

}
