package ArraysLeet;

import java.util.ArrayList;
import java.util.List;

public class Pascalarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(printPascal(31));
	}
	public static List<Integer> printPascal(int n) 
	{ 
		List<Integer> li = new ArrayList<Integer>();
	    for(int line = 1; line <= n; line++) 
	    { 
	          
	    long C=1;
	    for(int i = 1; i <= line; i++) 
	    {  
	    	if(line == n) {
	    		li.add((int)C);
	    	}
	        C = C * (line - i) / i;  
	    } 
	    System.out.println(); 
	    }
	    
	    return li;
	} 
}
